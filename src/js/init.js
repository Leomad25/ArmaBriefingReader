// load the initial login form
function getLoginFrom() {
    let str = '<link rel="stylesheet" href="src/css/login_form.css">';
    str += '<div class="login-form" id="login-form"><div class="inside">';
    str += '<div class="title">' + strings.login.title + '</div>';
    str += '<div class="logo"><img src="src/img/logo.png"></div>';
    str += '<div class="inputs" id="inputs">';
    str += '<button type="button" onclick="animations.login.startSesion()" id="login-btn">' + strings.login.btnLoginTag + '</button>';
    str += '<div class="inputs-p"><p onclick="func.login.skipToPanel()">' + strings.login.btnSkipToPanel + '</p>'; 
    str += '</div></div></div></div>';
    return str;
}
document.getElementById('main').innerHTML = getLoginFrom();