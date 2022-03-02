const func = {
    pageIndex: -1,
    navAsideState: 0,

    login: {
        skipToPanel: () => {
            func.header.calculateHeader();
            window.addEventListener('resize', () => {
                func.header.calculateHeader()
            });
        }
    },

    header: {
        calculateHeader: () => {
            screenWidth = document.getElementById('main').offsetWidth;
            navWidth = strings.debrief.length * strings.webConfig.navSize;
            if (screenWidth >= navWidth) {
                document.getElementById('header').innerHTML = func.header.getHeader();
            } else {
                document.getElementById('header').innerHTML = func.header.getHeader2();
            }
        },
        getHeader: () => {
            let str =  '<link rel="stylesheet" href="src/css/header1.css">' +
            '<table>' +
                '<tr><td>' +
                    '<table>' +
                        '<tr>' +
                            '<td class="td-logo"><img src="src/img/logo.png"></td>' +
                            '<td class="td-title">' +
                                '<h1>' + strings.header.title + '</h1>' +
                                '<h2>' + strings.header.subTitle + '</h2>' +
                            '</td>' +
                        '</tr>' +
                    '</table>' +
                '</td></tr>' +
                '<tr class="tr-nav"><td>' +
                    '<nav>' +
                        '<ul id="nav-list">' + func.header.getNavList() +'</ul>' +
                    '</nav>' +
                '</td></tr>' +
            '</table>';
            return str;
        },
        getHeader2:() => {
            let str =  '<link rel="stylesheet" href="src/css/header2.css">' +
            '<table>' +
                '<tr><td>' +
                    '<table>' +
                        '<tr>' +
                            '<td class="td-logo"><img src="src/img/logo.png"></td>' +
                            '<td class="td-title">' +
                                '<h1>' + strings.header.title + '</h1>' +
                                '<h2>' + strings.header.subTitle + '</h2>' +
                            '</td>' +
                        '</tr>' +
                    '</table>' +
                '</td></tr>' +
                '<tr class="tr-nav"><td>' +
                    '<nav>' +
                        '<button id="btn-nav" onclick="func.panel.changeStateOfAside()">' +
                            '<section id="btn-aside-animation" class="aside-animation">' +
                                '<section id="bar-1"></section>' +
                                '<section id="bar-2"></section>' +
                            '</section>' +
                        '</button>' +
                    '</nav>' +
                '</td></tr>' +
            '</table>' +
            '<aside id="aside-list">' +
                '<ul id="nav-list">' + func.header.getNavList2() +'</ul>' +
            '</aside>';
            return str;
        },
        getNavList: () => {
            const debrief = strings.debrief;
            if ( debrief.length > 0 ) {
                func.pageIndex = 0;
                func.panel.loadMain(func.pageIndex);
                var str = '', i = 0;
                debrief.forEach((element) => {
                    str += '<li id="nav-item-' + i + '"';
                    if ( i == 0 ) str += ' class="isSelect"';
                    str += ' style="width: ' + strings.webConfig.navSize + 'px;"><div class="btn-animation"></div>';
                    str += '<p>' + element.nav + '</p>';
                    str += '<div class="btn-nav" onclick="func.header.updateNatList(' + i +')"></div>';
                    str += '</li>';
                    i++;
                });
                return str;
            } else {
                func.panel.loadMain(-1);
                return '<p>No se ha encontrado informacion en el debrifing</p>';
            }
        },
        getNavList2: () => {
            const debrief = strings.debrief;
            if ( debrief.length > 0 ) {
                func.pageIndex = 0;
                func.panel.loadMain(func.pageIndex);
                var str = '', i = 0;
                debrief.forEach((element) => {
                    str += '<li id="nav-item-' + i + '"';
                    if ( i == 0 ) str += ' class="isSelect"';
                    str += '">';
                    str += '<p>' + element.nav + '</p>';
                    str += '<div class="btn-nav" onclick="func.header.updateNatList(' + i +')"></div>';
                    str += '</li>';
                    i++;
                });
                return str;
            } else {
                func.panel.loadMain(-1);
                return '<p>No se ha encontrado informacion en el debrifing</p>';
            }
        },
        updateNatList: (index) => {
            if ( index != func.pageIndex ) {
                func.pageIndex = index;
                if (index >= 0 && index < strings.debrief.length) {
                    for (let i = 0; i < strings.debrief.length; i++) {
                        const element = document.getElementById('nav-item-' + i);
                        if ( i != index ) {
                            element.className = '';
                        } else {
                            element.className = 'isSelect';
                        }
                        func.panel.loadMain(func.pageIndex);
                    }
                } else {
                    updateNatList(0);
                }
            }
        } 
    },

    panel: {
        loadMain: (index) => {
            if (index >= 0 && index < strings.debrief.length ) {
                document.getElementById('main').innerHTML = func.panel.getContent(index);
                func.panel.loadPerformance(index);
            } else {
                document.getElementById('main').innerHTML = 'El index del nav no existe.';
            }
        },
        changeStateOfAside: () => {
            if (func.navAsideState == 1) {
                const navList = document.getElementById('nav-list');
                animations.header.closeNav();
                func.navAsideState = 0;
                setTimeout(() => {
                    for (let i = 0; i < navList.children.length; i++) {
                        navList.children[i].firstChild.style.display = 'none';
                    }
                }, 1100);
            } else if (func.navAsideState == 0) {
                animations.header.openNav();
                func.navAsideState = 1;
            } else {
                func.navAsideState = 1;
            }
        },
        getContent: (index) => {
            if (index >= 0 && index < strings.debrief.length ) {
                const element = strings.debrief[index];
                let str = '<link rel="stylesheet" href="src/css/panel.css">';
                if ( element.title ) str += '<section class="title" id="main-title"><h1>' + element.title + '</h1></section>';
                if ( element.description ) str += '<section class="description" id="main-description"><p>' + element.description + '</p></section>';
                if ( element.map ) str += '<section class="map" id="main-map"><img src="' + element.map + '"></section>';
                if ( element.objectives ) {
                    str += '<section class="objectives" id="main-objectives">';
                    str += '<h1>' + strings.panel.objectivesTag + '</h1>';
                    element.objectives.forEach((subElement) => {
                        str += '<section class="subObj">';
                        str += '<p>' + subElement.description + '</p>';
                        if ( subElement.images ) {
                            str += '<ul class="subObj-image">';
                            const pathname = window.location.pathname.split('/');
                            let newPathname = 'file://';
                            for (let i = 0; i < (pathname.length -1); i++) newPathname += pathname[i] + '/';
                            str += '<li class="separator"></li>';
                            subElement.images.forEach((subImage) => {
                                str += '<li class="image">';
                                str += '<img src="' + subImage + '">';
                                str += '<div class="btn-image" onclick="func.panel.openImage(\'' + newPathname + subImage + '\')"></div>';
                                str += '</li>';
                                str += '<li class="separator"></li>';
                            });
                            str += '</ul>';
                        }
                        str += '</section>';
                    });
                    str += '</section>';
                }
                return str;
            } else {
                return 'El index ingresado no existe.';
            }
        },
        loadPerformance: (index) => {
            if (index >= 0 && index < strings.debrief.length) {
                if (strings.debrief[index].map) {
                    // init map image performance.
                    const map = document.getElementById('main-map').firstChild;
                    if (strings.debrief.length == strings.webConfig.heightMapImages.length) {
                        map.style.maxHeight = strings.webConfig.heightMapImages[index] + 'px';
                        map.style.maxWidth = '100%';
                    } else {
                        console.log(
                            '> Error:\n' +
                            '\tEl tamaño de ( strings.debrief.length ) es de: ' + strings.debrief.length + '.\n' +
                            '\tEl tamaño de ( strings.webConfig.heightMapImages.length ) es de: ' + strings.webConfig.heightMapImages.length + '.');
                    }
                    // end of map image performance.
                }
            } else {
                console.log(
                    '> Error:\n' +
                    '\tEl tamaño del \'index\' de ( func.panel.loadPerformance(index) ) es de: ' + index + '.\n' +
                    '\tEl tamaño de ( strings.debrief.length ) es de: ' + strings.debrief.length + '.');
            }
        },
        openImage: (url) => {
            window.open(url, "Image", "width=1080, height=720");
        }
    }
}