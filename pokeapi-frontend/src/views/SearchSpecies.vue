<template>
	<div>
		<h2 style="text-align:left; margin-bottom:30px;">Search species by name or id</h2>

		<b-form inline style="margin-bottom:20px;" @submit.prevent="getSpecies">
			<label style="margin-right:10px;" for="inline-form-input-name">Species name or id:</label>
			<b-input id="inline-form-input-name" class="mb-2 mr-sm-2 mb-sm-0" placeholder="tentacool or 72" v-model="nameOrId" />

			<b-button variant="primary" @click="getSpecies">Search</b-button>
		</b-form>

		<div style="overflow: auto;">
			<b-alert variant="danger" :show="errorMessage != null && !isLoading" style="text-align:left;">{{ errorMessage }}</b-alert>
			<div class="spinner-border" style="float:left;" v-if="isLoading">
				<span class="sr-only">Loading...</span>
			</div>
		</div>

		<b-card v-if="species" :title="species.name" :sub-title="'Id: ' + species.id.toString()" style="width:50%;">
			<b-list-group style="text-align:left; font-style:italic; ">
				<b-list-group-item>order: {{ species.order }}</b-list-group-item>
				<b-list-group-item>gender_rate: {{ species.gender_rate }}</b-list-group-item>
				<b-list-group-item>capture_rate: {{ species.capture_rate }}</b-list-group-item>
				<b-list-group-item>base_happiness: {{ species.base_happiness }}</b-list-group-item>
				<b-list-group-item>is_baby: {{ species.is_baby }}</b-list-group-item>
				<b-list-group-item>hatch_counter: {{ species.hatch_counter }}</b-list-group-item>
				<b-list-group-item>has_gender_differences: {{ species.has_gender_differences }}</b-list-group-item>
				<b-list-group-item>forms_switchable: {{ species.forms_switchable }}</b-list-group-item>
				<b-list-group-item>growth_rate: {{ species.growth_rate }}</b-list-group-item>
				<b-list-group-item>egg_groups: {{ species.egg_groups }}</b-list-group-item>
				<b-list-group-item>color: {{ species.color }}</b-list-group-item>
				<b-list-group-item>shape: {{ species.shape }}</b-list-group-item>
				<b-list-group-item>evolves_from_species: {{ species.evolves_from_species }}</b-list-group-item>
				<b-list-group-item>habitat: {{ species.habitat }}</b-list-group-item>
				<b-list-group-item>generation: {{ species.generation }}</b-list-group-item>
			</b-list-group>
		</b-card>
	</div>
</template>

<script>
import SpeciesService from "../services/species.service"

export default {
	name: "SearchSpecies",

	data() {
		return {
			nameOrId: null,
			species: null,
			errorMessage: null,
			isLoading: false,
		}
	},

	methods: {
		getSpecies() {
			if (!this.nameOrId) {
				this.errorMessage = "Name or id is empty!"
				return
			}

			this.isLoading = true
			this.species = null

			SpeciesService.getSpecies(this.nameOrId).then(
				(res) => {
					this.species = res.data
					this.errorMessage = null
					this.isLoading = false
				},
				(err) => {
					this.species = null
					this.errorMessage = err.response.data
					this.isLoading = false
				}
			)
		},
	},
}
</script>

<style></style>
