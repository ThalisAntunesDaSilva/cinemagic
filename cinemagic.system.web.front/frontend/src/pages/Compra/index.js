import React, { useState, useEffect } from 'react';


import './styles.css';
import navBar from '../../components/navBar/index.js';
import cardFilme from '../../components/cardFilme/index.js';




export default function Home() {
  
    return (
        <>
                    
                        <div className="formCompre">  
                            {navBar()}
                           {cardFilme()}
                        </div>



            
        </>
    );





}