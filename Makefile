#quick and dirty Makefile

.SUFFIXES: .java .class

JAVA_TAGS = -tag pre:cm:"Precondition:"  -tag post:cm:"Postcondition:"

CLASSES = "LIBS/commons-io-2.4.jar"


all: classes
	javac -d classes -cp $(CLASSES) ./FONTS/DOMINIO/CLASES/*.java ./FONTS/PERSISTENCIA/*.java ./FONTS/DOMINIO/CONTROLADORES/*.java ./FONTS/DOMINIO/CONTROLADORES/DRIVERS/*.java




## Extrae el contenido del jar en classes
## En el caso de guava nos interesa la carpeta "com"

libExtract:
	cd classes; jar xf ../EXEC/*.jar;

run:
	#java ./FONTS/DOMINIO/CLASES/*.java
	#java ./FONTS/PERSISTENCIA/*.java
	#java ./FONTS/DOMINIO/CONTROLADORES/*.java
	java ./FONTS/DOMINIO/CONTROLADORES/DRIVERS/SuperDriver.java

DriverTauler:
	@java -cp $(CLASSES) DOMINIO.CONTROLADORES.DRIVERS.Driver_ctrl_tablero

DriverPartida:
	@java -cp $(CLASSES) DOMINIO.CONTROLADORES.DRIVERS.DriverJugarPartida


DriverGestionUsuario:
	@java -cp $(CLASSES) DOMINIO.CONTROLADORES.DRIVERS.DriverGestionUsuario
DriverEstadisticas:
		@java -cp $(CLASSES) DOMINIO.CONTROLADORES.DRIVERS.DriverEstadisticas


doc:
	@javadoc -private $(JAVA_TAGS) -d html -sourcepath FONTS -classpath $(CLASSES) -subpackages DOMINIO.CLASES:DOMINIO.CONTROLADORES:DOMINIO.CONTROLADORES:PERSISTENCIA

classes:
	@mkdir -p classes

jar: all
	@unzip jar LIBS/commons-io.2.4.jar
	@jar -cvfm JuegoHidato.jar LIBS/commons-io.2.4-jar -C classes .

clean:
	@rm -rf classes latex html JuegoHidato.jar
