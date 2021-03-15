import React, { useState, useEffect } from 'react';
import cardResultado from '../../components/cardResultado/index.js';



export default function Pesquisa() {
    return (
        <>
            <div className="body">
                { cardResultado()}
            </div>
        </>
    );
}