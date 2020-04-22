import Vue from "vue"
import VueRouter from "vue-router"
import ViewBerries from "../views/ViewBerries.vue"
import SearchSpecies from "../views/SearchSpecies.vue"

Vue.use(VueRouter)

const routes = [
	{
		path: "/berry",
		name: "ViewBerries",
		component: ViewBerries,
	},

	{
		path: "/searchSpecies",
		name: "SearchSpecies",
		component: SearchSpecies,
	},
]

const router = new VueRouter({
	mode: "history",
	routes,
})

export default router
