<template>
  <div id="map" style="height: 600px;"></div>
</template>

<script>
import axios from 'axios';
import L from 'leaflet';
import 'leaflet/dist/leaflet.css';
import 'leaflet.markercluster/dist/MarkerCluster.css';
import 'leaflet.markercluster/dist/MarkerCluster.Default.css';
import 'leaflet.markercluster';

export default {
  name: 'MapComponent',
  data() {
    return {
      map: null,
      markerCluster: null,
      locations: []
    };
  },
  mounted() {
    this.initMap();
    this.fetchLocations();
  },
  methods: {
    initMap() {
      this.map = L.map('map').setView([51.505, -0.09], 13);
      L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 19,
        attribution: '© OpenStreetMap'
      }).addTo(this.map);

      this.markerCluster = L.markerClusterGroup();
      this.map.addLayer(this.markerCluster);
    },
    fetchLocations() {
      axios.get('/api/map')
        .then(response => {
          this.locations = response.data;
          this.addMarkers();
        })
        .catch(error => {
          console.error('Error fetching locations:', error);
        });
    },
    addMarkers() {
      this.locations.forEach(location => {
        const marker = L.marker([location.latitude, location.longitude])
          .bindPopup(`<b>${location.name}</b><br>${location.type}`);
        this.markerCluster.addLayer(marker);
      });
    }
  }
};
</script>
  
  <style scoped>
  #map {
    width: 70vw; /* 80% of the viewport width */
    height: 64vh; /* 80% of the remaining vertical space */
    margin-top: 16vh; /* 20% of the vertical space is used as top margin */
    float: right; /* Align the map to the right side of the viewport */
  }
  </style>
  