const botonAceptarCookies = document.getElementById('btn-aceptar-cookies');
const botonCancelarookies = document.getElementById('btn-cancelar-cookies');
const avisoCookies = document.getElementById('aviso-cookies');
const fondoAvisoCookies = document.getElementById('fondo-aviso-cookies');

dataLayer = [];

if(!localStorage.getItem('cookies-aceptadas')){
	avisoCookies.classList.add('activo');
	fondoAvisoCookies.classList.add('activo');
} else {
	dataLayer.push({'event': 'cookies-aceptadas'});
}

botonAceptarCookies.addEventListener('click', () => {
	avisoCookies.classList.remove('activo');
	fondoAvisoCookies.classList.remove('activo');

	localStorage.setItem('cookies-aceptadas', true);
	
	dataLayer.push({'event': 'cookies-aceptadas'});
	location.reload();
});

botonCancelarookies.addEventListener('click', () => {
	if(localStorage.length > 0){
		localStorage.removeItem('cookies-aceptadas');
		dataLayer.push({'event': 'cookies-no-aceptadas'});
	}
	
	avisoCookies.classList.remove('activo');
	fondoAvisoCookies.classList.remove('activo');
	localStorage.setItem('cookies-aceptadas', false);
	location.reload();
});