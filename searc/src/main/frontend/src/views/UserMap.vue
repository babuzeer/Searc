<template>
    <div id="map" style="height: 600px;"></div>
  </template>
  
  <script>
  import L from 'leaflet';
  import 'leaflet/dist/leaflet.css';
  
  export default {
    name: 'MapComponent',
    mounted() {
      this.initMap();
    },
    methods: {
      initMap() {
        const map = L.map('map').setView([51.505, -0.09], 13);
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
          maxZoom: 19,
          attribution: '© OpenStreetMap'
        }).addTo(map);
  
        // 示例：添加一个标记
        L.marker([51.5, -0.09]).addTo(map)
          .bindPopup('一个简单的标记')
          .openPopup();
      }
    }
  }
  </script>
  
  <style scoped>
  #map {
    width: 70vw; /* 80% of the viewport width */
    height: 64vh; /* 80% of the remaining vertical space */
    margin-top: 16vh; /* 20% of the vertical space is used as top margin */
    float: right; /* Align the map to the right side of the viewport */
  }
  </style>
  