package carona

import carona.security.Person

class Carona {

	String localDestino
	String bairroPartida
	String bairroDestino
	int vagas
	Date data
	List<Person> person
	
    static constraints = {
    }
	
	static belongsTo = [person:Person]
	
	static hasOne = [trajeto:Trajeto]
}
