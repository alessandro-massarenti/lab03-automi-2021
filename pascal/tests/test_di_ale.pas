program testdiale;   

var
  x, y, b, s,z: integer;

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

    if x <= z  then
    begin
	    writeln(x);
    end
    else begin
        writeln('ciao');
    end;
    repeat
        b := y;
        b := b % 2; // randomness by user input
	    if b = 1 then 
	    begin
		    x := x + 1;
		end
		else begin
		    x := x - 1;
		end;
	    s := s + 1;
        writeln(s);
    until x <= 0;
end.
