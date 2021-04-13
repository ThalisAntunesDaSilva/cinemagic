import React, { useState, useEffect } from 'react';
import formFilme from '../../components/formFilme/index.js';

export default function CadastroFilme() {

    return (
        <>
            <div className="body">
                {formFilme()}
            </div>
        </>
    );
}