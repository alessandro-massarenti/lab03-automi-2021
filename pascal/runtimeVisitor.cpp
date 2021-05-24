#include <iostream>
#include <string>
#include <exception>
#include "runtimeVisitor.h"

using namespace std;

antlrcpp::Any runtimeVisitor::visitId_list(pascalParser::Id_listContext *ctx) {
    // Prima variabile nella lista di identificatori
    string varname = ctx->ID()->getText();
    // Resto della lista
    pascalParser::Id_listContext *tail = ctx->id_list();
    // controllo che la variabile non sia già stata dichiarata
    if(this->vars.find(varname) != this->vars.end()) {
        cerr << "Error: Duplicate variable declaration '" << varname << "'" << endl;
        exit(EXIT_FAILURE);
    }
    this->vars[varname] = 0;
    // Continua sul resto della lista di identificatori, se presente
    if(tail != NULL) 
        return visitId_list(tail);
    return NULL;
}

antlrcpp::Any runtimeVisitor::visitAssign(pascalParser::AssignContext *ctx) {
    // Estraggo il nome della variabile dal testo del blocco ID di assign
    string varname = ctx->ID()->getText();
    // controllo che la variabile sia stata dichiarata
    if(this->vars.find(varname) == this->vars.end()) {
        cerr << "Error: Undefined variable '" << varname << "'" << endl;
        exit(EXIT_FAILURE);
    }
    // Estraggo il valore della variabile dal blocco expr di assign
    int value = visitExpr(ctx->expr());
    // Assegno alla variabile ID il valore di expr
    this->vars[varname] = value;
    
    // Ritorno NULL dato che il metodo si occupa di assegnazioni senza ritornare niente
    return NULL;
}

antlrcpp::Any runtimeVisitor::visitOut(pascalParser::OutContext *ctx) {
    // Questo metodo stampa il valore del blocco di out
    // Caso expr : stampo il valore di una espressione
    if(ctx->expr() != NULL) {
        // Se esiste expr allora salvo il suo valore calcolato da visitExpr e lo stampo su stdout
        int value = visitExpr(ctx->expr());
        cout << value << endl;
    }
    // Caso STRING : stampo la stringa contenuta in out
    if(ctx->STRING() != NULL){
        // Se esiste STRING allora estraggo il suo testo e lo stampo direttamente su stdout 
        cout << ctx->STRING()->getText() << endl;
    }

    // Ritorno NULL dato che il metodo si occupa di gestire stampe su stdout
    return NULL;
}

antlrcpp::Any runtimeVisitor::visitIn(pascalParser::InContext *ctx) {
    ///////
    cin >> vars[ctx->ID()->getText()];
    //legge dell'input da tastiera
    // il metodo deve aggiornare il valore della variabile
    return NULL;
}


antlrcpp::Any runtimeVisitor::visitBranch(pascalParser::BranchContext *ctx) {
    ///////
    // stabilisce il valore della guardia
    bool guard = visitGuard(ctx->guard());
    if(guard) {
        // se guardia vera, esegue ramo then
        visitCode_block(ctx->code_block(0));
    }else{
        if(ctx->code_block(1)){
            visitCode_block(ctx->code_block(1));
        }
    }
    //Esegue il ramo else (se presente) quando la guardia è falsa 
    return NULL;
}

antlrcpp::Any runtimeVisitor::visitLoop(pascalParser::LoopContext *ctx) {
    visitSt_list(ctx->st_list());
    if(!visitGuard(ctx->guard())){
        visitLoop(ctx);
    }
    // Implementa l'esecuzione del ciclo repeat-until
    // (da controllare)
    return NULL;

    ///////
}

antlrcpp::Any runtimeVisitor::visitExpr(pascalParser::ExprContext *ctx) {
    // controllo in quale caso sono
    int value = 0;
    if(ctx->ID() != NULL) {
        // caso ID
        string varname = ctx->ID()->getText();
        if(this->vars.find(varname) == this->vars.end()) {
            cerr << "Error: Undefined variable '" << varname << "'" << endl;
            exit(EXIT_FAILURE);
        }
        value = this->vars[varname];
    } else if(ctx->NUMBER() != NULL) {
        // caso NUMBER
        string numtext = ctx->NUMBER()->getText();
        value = std::stoi(numtext); 
    } else if(ctx->PLUS() != NULL) {
        // caso expr + expr
        // calcolo il valore della prima expr
        int left = visitExpr(ctx->expr(0));
        // calcolo il valore della seconda expr
        int right = visitExpr(ctx->expr(1));
        // il risultato finale è la somma
        value = left + right;
    } else if(ctx->MINUS() != NULL) {
        // caso expr - expr
        // calcolo il valore della prima expr
        int left = visitExpr(ctx->expr(0));
        // calcolo il valore della seconda expr
        int right = visitExpr(ctx->expr(1));
        // il risultato finale è la differenza
        value = left - right;
    } else if(ctx->MULT() != NULL) {
        // caso expr * expr
        // calcolo il valore della prima expr
        int left = visitExpr(ctx->expr(0));
        // calcolo il valore della seconda expr
        int right = visitExpr(ctx->expr(1));
        // il risultato finale è la moltiplicazione
        value = left * right;
    } else if(ctx->DIV() != NULL) {
        // caso expr / expr
        // calcolo il valore della prima expr
        int left = visitExpr(ctx->expr(0));
        // calcolo il valore della seconda expr
        int right = visitExpr(ctx->expr(1));
        // il risultato finale è la divisione
        value = left / right;
    } else if(ctx->MOD() != NULL) {
        // caso expr % expr
        // calcolo il valore della prima expr
        int left = visitExpr(ctx->expr(0));
        // calcolo il valore della seconda expr
        int right = visitExpr(ctx->expr(1));
        // il risultato finale è il modulo
        value = left % right;
    } else if(ctx->expr().size() == 1) {
        // caso parentesi
        value = visitExpr(ctx->expr(0));
    } 
    return value;
}

antlrcpp::Any runtimeVisitor::visitGuard(pascalParser::GuardContext *ctx) {

    // Valuta un' espressione booleana
    // Il metodo ritorna true se l'espressione è vera, false altrimenti

    // Verifica se ci sono guardie da valutare
    if(!ctx->relation()){
        // Se entro vuol dire che devo ancora valutare le relation che compongono la guard

        // Caso NOT guard : devo restituire true sse la guardia non è verificata  
        if(ctx->NOT()){
            // Richiamo ricorsivamente visitGuard per gestire possibili espressioni annidate
            // Al ritorno della ricorsione ottengo un valore booleano che poi devo restituire negato 
            return !visitGuard(ctx->guard(0));
        }

        // Caso guard AND guard : devo restituire true sse entrambe le guardie sono verificate
        if(ctx->AND()){
            // Richiamo ricorsivamente visitGuard su entrambi i membri della guardia
            // Al ritorno dalla ricorsione si entra nell'if sse entrambe sono verificate e quindi restituisce true   
            if (visitGuard(ctx->guard(0)) && visitGuard(ctx->guard(1)))
                return true;
            return false;
        }

        // Caso guard OR guard : devo restituire true sse almeno una guardia è verificata
        if(ctx->OR()){
            // Richiamo ricorsivamente visitGuard su entrambi i membri della guardia
            // Al ritorno dalla ricorsione si entra nell'if sse almeno uno dei due membri è verificato e quindi restituisce true
            if (visitGuard(ctx->guard(0)) || visitGuard(ctx->guard(1)))
                return true;
            return false;
        }

        // Caso '(' guard ')' : richiamo visitGuard sulla guardia  
        return visitGuard(ctx->guard(0));
    }

    // Se non sono entrato nell'if allora vuol dire che sono arrivato ricorsivamente alla relazione di base che
    // compone la guardia. Richiamo visitRelation su di essa e restituisco il valore booleano di tale relazione 
    return visitRelation(ctx->relation());
}

antlrcpp::Any runtimeVisitor::visitRelation(pascalParser::RelationContext *ctx) {
    // Il metodo ritorna true se il confronto è vero, false altrimenti

    //(da controllare)
    //Per entrare in questa funzione bisogna che sia una relazione

    //Int perchè le var sono tutte interi in questa casistica non saprei bene come implementare
    int values[2];

    for(int i = 0; i < 2; i ++){
        if(ctx->expr(i)->ID()){
            if(vars.find(ctx->expr(i)->getText()) != vars.end())
                values[i] = vars[ctx->expr(i)->getText()];
            else
                throw "La variabile non è mai stata allocata Sigsev zio";
        }else if(ctx->expr(i)->NUMBER()){
            values[i] = stoi(ctx->expr(i)->getText());
        }   
    }

    // Caso < : ritorna true se il primo blocco dell'espressione è strettamente minore del secondo
    if(ctx->LT()){
        // Verifica se il primo blocco dell'espressione è strettamente minore del secondo e se è vero restituisce true
        if(values[0] < values[1])
            return true;
    }
    // Caso <= : ritorna true se il primo blocco dell'espressione è minore o uguale del secondo
    if(ctx->LEQ()){
        
        // Verifica se il primo blocco dell'espressione è minore o oguale del secondo e se è vero restituisce true
        if(values[0] <= values[1])
            return true;
    }
    // Caso == : ritorna true se il primo e il secondo blocco dell'espressione sono uguali
    if(ctx->EQ()){
        // Verifica se c'è uguaglianza tra primo e secondo blocco dell'espressione e restituisce true se è vero
        if(values[0] == values[1])
            return true;
    }
    // Caso != : ritorna true se il primo e il secondo blocco dell'espressione sono diversi
    if(ctx->NEQ()){
        // Verifica se primo e secondo blocco dell'espressione sono diversi e ritorna true se è vero
        if(values[0] != values[1])
            return true;
    }
    // Caso >= : ritorna true se il primo blocco dell'epressione è maggiore o uguale del secondo
    if(ctx->GEQ()){
        // Verifica se il primo blocco dell'espressione è maggiore o uguale del secondo e restituisce true se è vero
        if(values[0] >= values[1])
            return true;
    }
    // Caso > : ritorna true se il primo blocco dell'espressione è strettamente maggiore del secondo 
    if(ctx->GT()){
        // Verifica se il primo blocco dell'espressione è strettamente minore del secondo blocco e restituisce true se è vero
        if(values[0] > values[1])
            return true;
    }

    // Se la relazione valutata non è verificata il metodo arriva a questo punto e restituisce false
    // Posizionato esternamente dai vari casi a fine metodo agisce da "valore di default", assumendo che 
    // se non ho trovato una relazione verificata e/o un errore devo restituire false 
    return false;
}

