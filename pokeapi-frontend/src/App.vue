<template>
	<div id="app">
		<Header />
		<b-card-body class="text-center">
			<router-view />
		</b-card-body>
	</div>
</template>

<script>
import Header from "./components/layout/Header"

export default {
	name: "app",
	components: {
		Header,
	},
}
</script>

<style>
#app {
	font-family: "Avenir", Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	text-align: center;
	color: #2c3e50;
	background-color: #f3f8fd;
}

#nav {
	padding: 30px;
}

#nav a {
	font-weight: bold;
	color: #2c3e50;
}
</style>
