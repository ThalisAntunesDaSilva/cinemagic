import React, { useState, useEffect } from 'react';
import menu from '../../components/menu/index.js';
import 'bootstrap/dist/css/bootstrap.min.css';


export default function ResultadoPesquisaTeste() {
    return (
        <>
            <div className="body">
                { menu()}
            </div>
        </>
    );
}