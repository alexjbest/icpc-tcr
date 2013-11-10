JAVAC=javac
sources = $(wildcard *.java)
classes = $(sources:.java=.class)

default: $(classes) test tex

clean :
	rm -f *.class \
	rm -f teamref.log \
	rm -f teamref.aux \

%.class : %.java
	$(JAVAC) $<

test : $(classes)
	java tester

tex : test
	pdflatex teamref.tex
