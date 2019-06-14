<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="title">Autolib' - Carte</jsp:attribute>
	<jsp:body>
		<div id="map"></div>
		<script src="https://unpkg.com/leaflet@1.3.1/dist/leaflet.js" integrity="sha512-/Nsx9X4HebavoBvEBuyp3I7od5tA0UzAxs+j83KgC8PU0kgB4XiK4Lfe4y4cgBtaRJQEIFCW+oC506aPT2L1zw==" crossorigin=""></script>
		<script type="text/javascript">
			// On initialise la latitude et la longitude de Paris (centre de la carte)
			window.addEventListener('load', () => {
				let lat = 45.764043;
				let lon = 4.835659;

				// Créer l'objet "macarte" et l'insèrer dans l'élément HTML qui a l'ID "map"
				let macarte = L.map('map').setView([lat, lon], 13);
				// Leaflet ne récupère pas les cartes (tiles) sur un serveur par défaut. Nous devons lui préciser où nous souhaitons les récupérer. Ici, openstreetmap.fr
				L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png', {
					// Il est toujours bien de laisser le lien vers la source des données
					attribution: 'données © <a href="//osm.org/copyright">OpenStreetMap</a>/ODbL - rendu <a href="//openstreetmap.fr">OSM France</a>',
					minZoom: 1,
					maxZoom: 20
				}).addTo(macarte);

				<c:forEach items="${stations}" var="item">
					L.marker([${item.latitude}, ${item.longitude}]).addTo(macarte).on('click', function(e) {
						window.location.href = <c:url value="/stations/${item.id}"/>;
					});
				</c:forEach>
			});
		</script>
		<style type="text/css">
			#map { /* la carte DOIT avoir une hauteur sinon elle n'apparaît pas */
				height: 70vh;
				margin: 3rem;
			}
		</style>
	</jsp:body>
</t:layout>