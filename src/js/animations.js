const animations = {
    login: {
        startSesion: () => {
            document.getElementById('login-btn').style = 'animation-name: btnVanish; animation-duration: .5s;';
            setTimeout(() => {
                animationsFun.login.startSecuence();
            }, 500);
        },
        closeLogin: () => {
            document.getElementById('login-form').style.animationName = 'loginVanish';
            document.getElementById('login-form').style.animationDuration = '.5s';
            setTimeout(() => {
                document.getElementById('main').innerHTML = animationsFun.topSecret.getHTML();
                animationsFun.topSecret.appear();
            }, 480);
        }
    },
    header: {
        btnOpenNav: () => {
            document.getElementById('bar-1').style.transform = 'translateX(-50%) translateY(-50%) rotate(45deg)';
            document.getElementById('bar-1').style.top = '50%';
            document.getElementById('bar-1').style.left = '50%'
            document.getElementById('bar-2').style.transform = 'translateX(-50%) translateY(-50%) rotate(135deg)';
            document.getElementById('bar-2').style.top = '50%';
            document.getElementById('bar-2').style.left = '50%';
        },
        btnCloseNav: () => {
            document.getElementById('bar-1').style.transform = 'translateX(-50%) translateY(-50%)';
            document.getElementById('bar-1').style.top = '33.3%';
            document.getElementById('bar-1').style.left = '50%'
            document.getElementById('bar-2').style.transform = 'translateX(-50%) translateY(-50%)';
            document.getElementById('bar-2').style.top = '66.6%';
            document.getElementById('bar-2').style.left = '50%';
        },
        openNav: () => {
            animations.header.btnOpenNav();
            const navList = document.getElementById('nav-list');
            navList.style.padding = '0 .5em';
            for (let i = 0; i < navList.children.length; i++) {
                navList.children[i].style.width = strings.webConfig.navSize + 'px';
            }
            setTimeout(() => {
                for (let i = 0; i < navList.children.length; i++) {
                    navList.children[i].firstChild.style.animationName = 'openAsideP';
                    navList.children[i].firstChild.style.animationDuration = '.3s'
                }
                setTimeout(() => {
                    for (let i = 0; i < navList.children.length; i++) {
                        navList.children[i].firstChild.style.display = 'block';
                    }
                }, 300);
            }, 500);
        },
        closeNav: () => {
            animations.header.btnCloseNav();
            const navList = document.getElementById('nav-list');
            for (let i = 0; i < navList.children.length; i++) {
                navList.children[i].firstChild.style.animationName = 'closeAsideP';
                navList.children[i].firstChild.style.animationDuration = '.5s'
            }
            setTimeout(() => {
                for (let i = 0; i < navList.children.length; i++) {
                    navList.children[i].firstChild.style.display = 'none';
                }
                navList.style.padding = '0 0em';
                for (let i = 0; i < navList.children.length; i++) {
                    navList.children[i].style.width = '0px';
                }
            }, 480);
        }
    }
}

const animationsFun = {
    login: {
        startSecuence: () => {
            document.getElementById('inputs').innerHTML = animationsFun.login.getLabels();
            document.getElementById('login-input-user').style = 'animation-name: loginInputsWidth; animation-duration: .5s;';
            document.getElementById('login-input-pass').style = 'animation-name: loginInputsWidth; animation-duration: .5s;';
            setTimeout(() => {
                document.getElementById('login-input-user').style.width = '80%';
                document.getElementById('login-input-pass').style.width = '80%';
                animationsFun.login.fillUser(0);
            }, 500);
        },
        getLabels: () => {
            const str = 
                '<div class="login-input-user" id="login-input-user"></div>'+
                '<div class="login-input-pass" id="login-input-pass"></div>';
            return str;
        },
        fillUser: (index) => {
            if (strings.login.user.length < index) {
                document.getElementById('login-input-user').style.backgroundColor = 'rgba(0,200,0,.4)';
                return animationsFun.login.fillPass(0);
            } else {
                document.getElementById('login-input-user').innerHTML = 
                    '<p>' + strings.login.user.slice(0, index + 1) + '</p>';
                setTimeout(() => {
                    return animationsFun.login.fillUser(index + 1);
                }, 80);
            }
        },
        fillPass: (index) => {
            if (strings.login.user.length < index) {
                document.getElementById('login-input-pass').style.backgroundColor = 'rgba(0,200,0,.4)';
                return animations.login.closeLogin();
            } else {
                document.getElementById('login-input-pass').innerHTML = 
                    '<p>' + strings.login.pass.slice(0, index + 1) + '</p>';
                setTimeout(() => {
                    return animationsFun.login.fillPass(index + 1);
                }, 80);
            }
        }
    },
    topSecret: {
        getHTML: () => {
            let str = '<link rel="stylesheet" href="src/css/top_secret.css">';
            str += '<div class="top-secret inside grey" id="top-secret"><div class="inside black"><div class="inside grey"><div class="inside black">'
            str += '<h1>' + strings.topSecret.tag + '</h1>';
            return str += '</div></div></div></div>';
        },
        appear: () => {
            document.getElementById('top-secret').style.animationName = 'topSecretAppear';
            document.getElementById('top-secret').style.animationDuration = '1s';
            setTimeout(() => {
                return animationsFun.topSecret.disappear();
            }, 1000);
        },
        disappear: () => {
            document.getElementById('top-secret').style.animationName = 'topSecretDisappear';
            document.getElementById('top-secret').style.animationDuration = '1s';
            setTimeout(() => {
                document.getElementById('main').innerHTML = animationsFun.topSecret.getOperationHTML();
                animationsFun.topSecret.appearOperation();
            }, 1000);
        },
        getOperationHTML: () => {
            let str = '<link rel="stylesheet" href="src/css/top_secret.css">';
            str += '<div class="top-secret inside grey" id="top-secret"><div class="inside black"><div class="inside grey"><div class="inside black">'
            str += '<h1>' + strings.topSecret.operationName + '</h1>';
            return str += '</div></div></div></div>';
        },
        appearOperation: () => {
            document.getElementById('top-secret').style.animationName = 'topSecretAppear';
            document.getElementById('top-secret').style.animationDuration = '2s';
            setTimeout(() => {
                return animationsFun.topSecret.disappearOperation();
            }, 2000);
        },
        disappearOperation: () => {
            document.getElementById('top-secret').style.animationName = 'topSecretDisappear';
            document.getElementById('top-secret').style.animationDuration = '3s';
            setTimeout(() => {
                document.getElementById('main').innerHTML = animationsFun.logo.getHTML();
                animationsFun.logo.appear();
            }, 3000);
        }
    },
    logo: {
        getHTML: () => {
            let str = '<link rel="stylesheet" href="src/css/logo.css">';
            str += '<div class="image" id="image">';
            str += '<img src="src/img/logo.png">';
            return str += '</div>';
        },
        appear: () => {
            document.getElementById('image').style.animationName = 'logoAppear';
            document.getElementById('image').style.animationDuration = '2s';
            setTimeout(() => {
                return animationsFun.logo.disappear();
            }, 2000);
        },
        disappear: () => {
            document.getElementById('image').style.animationName = 'logoDisappear';
            document.getElementById('image').style.animationDuration = '3s';
            setTimeout(() => {
                func.login.skipToPanel();
            }, 3000);
        }
    }
}
