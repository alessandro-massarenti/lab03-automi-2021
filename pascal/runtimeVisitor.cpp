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
    string varname = ctx->ID()->getText();
    // controllo che la variabile sia stata dichiarata
    if(this->vars.find(varname) == this->vars.end()) {
        cerr << "Error: Undefined variable '" << varname << "'" << endl;
        exit(EXIT_FAILURE);
    }
    int value = visitExpr(ctx->expr());
    this->vars[varname] = value;
    return NULL;
}

antlrcpp::Any runtimeVisitor::visitOut(pascalParser::OutContext *ctx) {
    ///////
    // verifico se devo stampare intero o stringa
    if(ctx->expr() != NULL) {
        // caso stampa intero
        int value = visitExpr(ctx->expr());
        cout << value << endl;
    }
    // Implementato il caso della stringa
    // (da controllare)
    if(ctx->STRING() != NULL){
        cout << ctx->STRING()->getText() << endl;
    }
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

    ///////

    // Valuta un' espressione booleana
    // il metodo ritorna true se l'espressione è vera, false altrimenti

    if(!ctx->relation()){

        if(ctx->NOT()){
            return !visitGuard(ctx->guard(0));
        }

        if(ctx->AND()){
            if (visitGuard(ctx->guard(0)) && visitGuard(ctx->guard(1)))
                return true;
        }

        if(ctx->OR()){
            if (visitGuard(ctx->guard(0)) || visitGuard(ctx->guard(1)))
                return true;
        }

        return visitGuard(ctx->guard(0));
    }

    return visitRelation(ctx->relation());
}

antlrcpp::Any runtimeVisitor::visitRelation(pascalParser::RelationContext *ctx) {
    // il metodo ritorna true se il confronto è vero, false altrimenti

    // Caso < : ritorna true se il primo blocco dell'espressione è minore del secondo
    if(ctx->LT()){
        if(vars[ctx->expr(0)->getText()] < vars[ctx->expr(1)->getText()])
            return true;
    }

    if(ctx->LEQ()){
        if(vars[ctx->expr(0)->getText()] <= vars[ctx->expr(1)->getText()])
            return true;
    }
    if(ctx->EQ()){
        if(vars[ctx->expr(0)->getText()] == vars[ctx->expr(1)->getText()])
            return true;
    }
    if(ctx->NEQ()){
        if(vars[ctx->expr(0)->getText()] != vars[ctx->expr(1)->getText()])
            return true;
    }
    if(ctx->GEQ()){
        if(vars[ctx->expr(0)->getText()] >= vars[ctx->expr(1)->getText()])
            return true;
    }
    if(ctx->GT()){
        if(vars[ctx->expr(0)->getText()] > vars[ctx->expr(1)->getText()])
            return true;
    }

    ///////

    // Quest è l'else di ognuno
    return false;
}

