JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Weather.java\
	Driver.java\
	Panel.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
