export default [
    {
        path: '/', component: 'main', children: [
            // {
            //     path: '/index',
            //     component: 'main/index'
            // },
            {
                path: '/itemlist',
                name: 'ItemList',
                component: "admin/itemList"
            },
            {
                path: '/additem',
                name: 'Additem',
                component: "admin/additem", //
            },
        ]
    },
    // {
    //     path: '/:msg*',
    //     component: "404/404",
    // }
]