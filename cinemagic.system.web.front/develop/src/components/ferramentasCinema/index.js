import React, { useState } from 'react';
import cinemagic from '../../assets/logo.png';
import './styles.css';



const Example = (props) => {

    return (
        <div className="home-container">

            <section className="header col-xs-15 col-sm-12 col-md-15 col-lg-12">

                <div className="header-centro">
                    <img src={cinemagic} className="header-centro" alt="cinemagic" />
                </div>

            </section>
        </div>
    );
}

export default Example;