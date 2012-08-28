package carona

class Trajeto {
	
	double latitudedInicio
	double longitudeInicio
	double latitutdeFim
	double longitudeFim
	
    static constraints = {
    }
	
	static belongsTo = [carona:Carona]
}
