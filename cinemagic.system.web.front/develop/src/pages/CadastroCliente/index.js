import React, { useState, useEffect } from 'react';
import formCadastro from '../../components/formCadastro/index.js';
import ferramentasCadastro from '../../components/ferramentasCadastro/index.js';




export default function CadastroCliente() {

    return (
        <>
            <div className="body">
                {ferramentasCadastro()}
                {formCadastro()}

            </div>

        </>
    );
}