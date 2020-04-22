import axios from "axios"

const API_URL = "http://localhost:8080/species"

class SpeciesService {
	getSpecies(nameOrId) {
		return axios.get(API_URL + "/" + nameOrId)
	}
}

export default new SpeciesService()
