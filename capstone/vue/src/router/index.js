import Vue from "vue";
import Router from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Logout from "../views/Logout.vue";
import OrgListing from "../views/OrgListing.vue";
import RegVol from "../views/RegVol.vue";
import RegOrg from "../views/RegOrg.vue";
import VolHome from "../views/VolHome.vue";
import store from "../store/index";
import EmptyMailbox from "../views/EmptyMailbox.vue";
import Message from "../views/Message.vue";
import NoMessage from "../views/NoMessage.vue";
import Mailbox from "../views/MailBox.vue";
import Events from "../views/Home.vue";//might delete

Vue.use(Router);

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/mailbox", 
      name: "mailbox", 
      component: Mailbox, 
      meta: {
        requiresAuth: false,
      }, 
    },
    {
      path: "/noMessage", 
      name: "noMessage",
      component: NoMessage,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/",
      name: "home",
      component: Home,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: '/:id',
      name: 'Events',//might delete
      component: Events,
      meta:{
        requiresAuth: true,
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/regVol",
      name: "regVol",
      component: RegVol,
      meta: {
        requiresAuth: false,
      },
    },
    {
      path: "/regOrg",
      name: "regOrg",
      component: RegOrg,
      meta: {
        requiresAuth: false,
      },
    },
      {
        path: "/emptyMailbox", 
        name: "emptyMailbox",
        component: EmptyMailbox,
        meta: {
          requiresAuth: false,
      },
    },
      {
        path: "/message",
        name: "message", 
        component: Message, 
        meta: {
          requiresAuth: false,
        },
      },
    {
      path: "/volHome",
      name: "volHome",
      component: VolHome,
      meta: {
        requiresAuth: true, //This will need to be changed to true. 

    },                       //False allows us to get around login. - Gabe
  },
    {
      path: "/orgListing",
      name: "orgListing",
      component: OrgListing,
      meta: {
        requiresAuth: false, //This will need to be changed to true. 
    },                       //False allows us to get around login. - Gabe
    },
  ]
});
  

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some((x) => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === "") {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
