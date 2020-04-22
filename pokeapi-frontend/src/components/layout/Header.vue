<template>
	<div>
		<b-navbar toggleable="lg" style="background-color:rgb(116, 183, 255);">
			<b-navbar-brand>
				<img src="https://raw.githubusercontent.com/PokeAPI/media/master/logo/pokeapi_256.png" height="50px;" />
			</b-navbar-brand>

			<b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

			<b-collapse id="nav-collapse" is-nav>
				<b-navbar-nav>
					<b-nav-item exact exact-active-class="active" to="/berry">View Berries</b-nav-item>
					<b-nav-item exact exact-active-class="active" to="/searchSpecies">Search</b-nav-item>
					<b-nav-item exact exact-active-class="active" @click="clearCache">Clear Cache</b-nav-item>
				</b-navbar-nav>
			</b-collapse>
		</b-navbar>
	</div>
</template>

<script>
import axios from "axios"

export default {
	methods: {
		clearCache() {
			axios.get("http://localhost:8080/clearCache")
		},
	},
}
</script>

<style scoped>
.navbar-light .navbar-nav .nav-link.active {
	color: white !important;
}

.nav-item {
	color: #ef5350;
}

.nav-link.active {
	color: #c62828;
}
</style>
