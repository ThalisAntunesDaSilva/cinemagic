import React, { Component } from 'react';
import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import Login from './pages/Login';
import Pesquisa from './pages/Pesquisa';
import Compra from './pages/Compra';



import {isAuthenticaded} from './services/auth/auth.js';

export default function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Home} />
                <Route path="/Login" exact component={Login} />
                <Route path="/Pesquisa" exact component={Pesquisa} />
                <Route path="/Compra" exact component={Compra} />
            </Switch>
        </BrowserRouter>
    );



const PrivateRoute = ({component: Component, ...rest}) => (
 
 
 
 
    <Route
    {...rest}
    render = {props =>
        isAuthenticaded()? (
            <Component {...props}/>
        ): (
            <Redirect to = {{ pathname: "/Login",state: {from: props.location}}} />
        )

    }
  />  
);
const PrivateRouteLogin = ({component: Component, ...rest}) => (
    <Route
      {...rest}
      render = {props =>
          !isAuthenticaded()? (
              <Component {...props}/>
          ): (
              <Redirect to = {{ pathname: "/",state: {from: props.location}}} />
          )
  
      }
    />  
  );




}