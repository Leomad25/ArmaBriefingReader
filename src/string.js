const strings = {
    // -------------------------------------------------- Login Form --------------------------------------------------
    login: {
        title: 'Red Lobo Blanco',
        btnLoginTag: 'Iniciar sesión',
        btnSkipToPanel: 'Ir al panel',
        user: 'Lobo Blanco',
        pass: 'Destacamento'
    },

    // -------------------------------------------------- Top Secret --------------------------------------------------
    topSecret: {
        tag: 'Top Secret',
        operationName: 'Operacion ejemplo'
    },

    // -------------------------------------------------- tags de la web --------------------------------------------------
    header: {
        title: 'Lobo Blanco - Brief',
        subTitle: 'Operacion ejemplo'
    },
    panel: {
        objectivesTag: 'Objetivos'
    },

    // -------------------------------------------------- web config --------------------------------------------------
    webConfig: {
        navSize: 160, // recomendado como minimo 70
        heightMapImages: [720, 0, 0, 0, 0]
            // importante: - tener la mimsa cantidad de numeros que breafings.
            //             - donde en el brifing no halla la etiquera 'map' dejar el valor como 0.
    },

    // -------------------------------------------------- debrief items --------------------------------------------------
    debrief: [
        /**
         * -- Formato
         *  {
         *      nav: 'nombre en la barra de navegaciones', // puede nombre de la escuadra a la cual va dirijido el debrif
         *      title: 'sub titulo del brefing',
         *      description: 'contenido del brefing',
         *      map: 'aqui url de la imagen del mapa',
         *      objectives: [
         *          {
         *              description: 'objetivo 1',
         *              images: [
         *                  'direccion de la imagen'
         *              ]
         *          }
         *      ]
         *  }
         * -- Formato
         * Si se agrega otro separar por comas
        */
        {
            nav: 'General',
            title: 'Tiempo de recuperar lo nuestro',
            description: 
                        '<b>HORA:</b> 0400 horas.' + // Las etiquetas <b></b> ponen en negrita todo lo que se encunetre dentro.
                        '<br>' + // esto es un salto de linea
                        'Un grupo de insurgentes rebeldes han robado equipo militar valioso para los estados unidos, se ha encomendado a LOBO BLANCO la tarea de recuperar dicho armamento.' +
                        '<br>' +
                        'Nuestros radares han identificado la última posición de los insurgentes en un complejo en las cordenadas para x-ray 0233 para yankee 1924.',
            map: 'src/img/map2.png',
            objectives: [
                {
                    description: 'Recuperar el cargamento del ejercito.',
                    images: [
                        'src/img/objectives/general_obj_1.png'
                    ]
                },
                {
                    description: 'Eliminar cualquier informacion que pueda poseer el enemigo, y quemar los recursos economicos del enemigo.',
                    images: [
                        'src/img/objectives/general_obj_2.png',
                        'src/img/objectives/general_obj_3.png',
                        'src/img/objectives/general_obj_2.png',
                        'src/img/objectives/general_obj_3.png'
                    ]
                }
            ]
        },
        {
            nav: 'Alpha',
            title: 'Misión Alpah',
            description: 'Esta es la descripción del grupo de Alpha.',
            objectives: [
                {
                    description: 'objetivo Alpah.'
                }
            ]
        },
        {
            nav: 'Bravo',
            title: 'Misión Bravo',
            description: 'Esta es la descripción del grupo de Bravo.',
            objectives: [
                {
                    description: 'objetivo Bravo.'
                }
            ]
        },
        {
            nav: 'Charlie',
            title: 'Misión Charlie',
            description: 'Esta es la descripción del grupo de Charlie.',
            objectives: [
                {
                    description: 'objetivo Charlie.'
                }
            ]
        },
        {
            nav: 'Zulu',
            title: 'Misión Zulu',
            description: 'Esta es la descripción del grupo de Zulu.',
            objectives: [
                {
                    description: 'objetivo Zulu.'
                }
            ]
        }
    ]
};