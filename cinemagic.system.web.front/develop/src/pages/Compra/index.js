import React, { useState, useEffect } from 'react';


import './styles.css';
import navBar from '../../components/navBar/index.js';
import cardFilme from '../../components/cardFilme/index.js';
import formularioDeCompra from '../../components/formularioDeCompra/index.js'



export default function Compra() {
  
    return (
        <>
                    



                        <div className="formCompre">  
                            {navBar()}
                           {cardFilme()}
                           {formularioDeCompra()}
                         </div>
                        
                        

                      

            
        </>
    );





}