program testdiale;   

var
  x, y: integer;

begin
    x := 10;
    y := 1100;

    if x <= y  then
    begin
	    writeln(x);
    end
    else begin
        writeln('ciao');
    end;

    x := 10;
    y := 10;

    if x <= 1000  then
    begin
	    writeln(x);
    end
    else begin
        writeln('ciao');
    end;
end.
