import React, { Component } from 'react';
import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import Home from './pages/Home';
import {isAuthenticaded} from './services/auth/auth.js';


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


export default function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact component={Home} />
            </Switch>
        </BrowserRouter>
    );

}