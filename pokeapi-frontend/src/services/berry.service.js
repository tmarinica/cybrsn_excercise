import axios from "axios"

const API_URL = "http://localhost:8080/berry"

class BerryService {
	getSortedBerries(sortField, sortOrder) {
		return axios.get(API_URL, {
			params: {
				sortField: sortField,
				sortOrder: sortOrder,
			},
		})
	}
}

export default new BerryService()
