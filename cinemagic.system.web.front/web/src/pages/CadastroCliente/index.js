import React, { useState } from 'react';
import logoImg from '../../assets/logo.png';
import bandeira from '../../assets/bandeira.png';
import api from '../../services/api';
import { Link } from 'react-router-dom';
import './styles.css';
import { FiMenu, FiSearch, FiCreditCard, FiMapPin } from 'react-icons/fi'

export default function CadastroCliente() {
    return (
        <>

            <section className="header col-xs-12 col-sm-12 col-md-12 col-lg-12">
                <div className="header-esquerda">
                    <img src={logoImg} className="head-logoImg" alt="cinemagic" />
                    <Link>
                        <FiMenu size={40} className="head-menuIcon" color="#ffffff" />
                    </Link>
                </div>
              

                <div className="header-direita">
                    <FiSearch className="head-searchIcon" size={0} color="#ffffff" />
                    <Link className="head-opcoes">...</Link>
                </div>
            </section>
            <div>
            <div className="title"> Cadastre-se </div>
                <form id="register-form">

                    <div className="body">
                        <div className="home-container">

                            <div class="half-box  spacing">
                                <label for="email"> E-mail</label>
                                <input type="email" name="email" id="email" placeholder="Digite seu e-mail" data-min-length="2"
                                    data-email-validate /></div>
                            <div class="half-box spacing ">
                                <label for="name"> Nome</label>
                                <input type="text" name="name" id="name" placeholder="Digite o seu nome" data-required data-min-length="3"
                                    data-max-length="16" />
                            </div>
                            <div class="half-box  spacing">
                                <label for="lastname"> Sobrenome</label>
                                <input type="text" name="lastname" id="lastname" placeholder="Digite o seu sobrenome" data-required
                                    data-only-letters />
                            </div>

                            <div class="half-box  spacing">
                                <label for="gender"> Sexo</label>
                                <input type="text" name="gender" id="gender" placeholder="Digite o seu genero" />
                            </div>

                            <div class="half-box spacing ">
                                <label for="cpf"> CPF </label>
                                <input type="text" name="cpf" id="cpf" placeholder="Digite o seu CPF" />
                            </div>

                            <div class="half-box  spacing">
                                <label for="datanascimento"> Data de Nascimento </label>
                                <input type="text" name="datanascimento" id="datanascimento" placeholder="Digite sua data de nascimento" />
                            </div>

                            <div class="half-box  spacing">
                                <label for="telefone"> Telefone (DDD + número) </label>
                                <input type="text" name="telefone" id=" telefone" placeholder="Digite o numero do telefone" />
                            </div>

                            <div class="half-box  spacing">
                                <label for="celular"> Celular (DDD + número) </label>
                                <input type="text" name="celular" id=" celular" placeholder="Digite o numero do celular" />
                            </div>

                            <div class="half-box  spacing">
                                <label for="cep"> CEP </label>
                                <input type="text" name="cep" id="cep" placeholder="Digite seu cep" />
                            </div>

                            <div class="half-box  spacing">
                                <label for="city"> Cidade</label>
                                <input type="text" name="city" id="city" placeholder="Digite o nome da sua cidade" />
                            </div>

                            <div class="half-box  spacing">
                                <label for="state"> Estado</label>
                                <input type="text" name="state" id="state" placeholder="Digite seu estado" />
                            </div>

                            <div class="half-box  spacing">
                                <label for="address"> Endereço </label>
                                <input type="text" name="address" id="address" placeholder="Digite seu endereço" />
                            </div>

                            <div class="half-box  spacing">
                                <label for="number"> Número </label>
                                <input type="text" name="number" id="number" placeholder="Digite seu numero" />
                            </div>

                            <div class="half-box  spacing">
                                <label for="district"> Bairro </label>
                                <input type="text" name="district" id="district" placeholder="Digite seu bairro" />
                            </div>

                            <div class="half-box  spacing">
                                <label for="complement"> Complemento </label>
                                <input type="text" name="complement" id="complement" />
                            </div>

                            <div class="half-box  spacing">
                                <label for="password"> Senha</label>
                                <input type="password" name="password" id="password" placeholder="Digite a sua senha" ddata-password-validate
                                    data-required />
                            </div>

                            <div class="half-box  spacing">
                                <label for="passconfirmation"> Confirmação de Senha</label>
                                <input type="password" name="passconfirmation" id="passconfirmation" placeholder="Confirme a sua senha"
                                    data-equal="password" />
                            </div>

                            <div class="ful-box ">
                                <input type="checkbox" name="agreement" id="agreement" />
                                <label for="agreement" id="agreement-label"> Eu li e aceito os <a>termos de uso</a></label>
                            </div>

                            <div class="ful-box ">
                                <input type="submit" id="btn-submit" valeu="Registrar" />
                            </div>

                            
                        </div>
                    </div>

                </form>
                <section className="rodape">
                                <div>
                                    <img src={bandeira} alt="bandeira" className="bandeira" />
                                </div>
                            </section>

            </div>

        </>
    );
}

