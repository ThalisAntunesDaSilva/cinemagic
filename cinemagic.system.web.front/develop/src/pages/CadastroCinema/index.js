import React, { useState, useEffect } from 'react';
import formCinema from '../../components/formCinema/index.js';
import ferramentasCinema from '../../components/ferramentasCinema/index.js';




export default function CadastroCinema() {

    return (
        <>
            <div className="body">
                {ferramentasCinema()}
                {formCinema()}

            </div>

        </>
    );
}