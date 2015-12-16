#quick and dirty Makefile

.SUFFIXES: .java .class

JAVA_TAGS = -tag pre:cm:"Precondition:"  -tag post:cm:"Postcondition:"

CLASSES = "LIBS/commons-io-2.4.jar"

all: classes
	javac -d classes -cp $(CLASSES) ./FONTS/CLUSTER/DOMINIO/CLASES/*.java ./FONTS/G45/*.java ./FONTS/CLUSTER/PERSISTENCIA/*.java ./FONTS/CLUSTER/DOMINIO/CONTROLADORES/*.java ./FONTS/CLUSTER/DOMINIO/CONTROLADORES/DRIVERS/*.java




## Extrae el contenido del jar en classes
## En el caso de guava nos interesa la carpeta "com"

libExtract:
	cd classes; jar xf ../EXEC/*.jar;

run:
	# java ./FONTS/DOMINIO/CLASES/*.java
	# java ./FONTS/PERSISTENCIA/*.java
	# java ./FONTS/DOMINIO/CONTROLADORES/*.java
#  chuta tras un mogollon de intentos
	ls -la ./classes/CLUSTER/DOMINIO/CONTROLADORES/DRIVERS
	cd ./classes; ls; java CLUSTER.DOMINIO.CONTROLADORES.DRIVERS.SuperDriver

DriverTauler:
	@java -cp DOMINIO.CONTROLADORES.DRIVERS.Driver_ctrl_tablero

DriverPartida:
	@java -cp DOMINIO.CONTROLADORES.DRIVERS.DriverJugarPartida


DriverGestionUsuario:
	@java -cp DOMINIO.CONTROLADORES.DRIVERS.DriverGestionUsuario
DriverEstadisticas:
		@java -cp DOMINIO.CONTROLADORES.DRIVERS.DriverEstadisticas


doc:
	@javadoc -private $(JAVA_TAGS) -d html -sourcepath FONTS -classpath -subpackages DOMINIO.CLASES:DOMINIO.CONTROLADORES:DOMINIO.CONTROLADORES:PERSISTENCIA

classes:
	@mkdir -p classes

jar: all
	#@unzip jar LIBS/commons-io.2.4.jar
	@jar -cvfm JuegoHidato.jar manifest.txt ./*/*/*/*/*.class ./*/*/*/*.class ./*/*/*.class

clean:
	@rm -rf classes latex html JuegoHidato.jar
