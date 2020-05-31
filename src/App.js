import React from 'react';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Table from 'react-bootstrap/Table';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
//import logo from './logo.svg';
import './App.css';

function App() {
  const titulo = 'Registro de empleados';
  return (
    <div className="App">
      <header className="App-header">



        <Container >
          <h2>{titulo}</h2>
          <br/>
          <Row>
          <Col>
          <div>
                <label className="label_form1">Nombre</label>
                <input className="input_form1" type="text" id="nombre"></input>
                <br/>
                <label className="label_form1">Apellido</label>
                <input className="input_form1" type="text" id="apellido"></input>
              </div>
          </Col>
          <Col>
          <div>
                <label className="label_form1">Correo    </label>
                <input className="input_form1" type="text" id="correo"></input>
                <br/>
                <label className="label_form1">Telefono</label>
                <input className="input_form1" type="text" id="telefono"></input>
              </div>
          </Col>
            
              
              
              
              
            
          </Row>
          <br/><br/><Button as="input" type="submit" value="Guardar" />{' '}<br/><br/>
          <Row>

            <Table striped bordered hover size="sm" id="table_registros">
              <thead>
                <tr>
                  <th>Nombre</th>
                  <th>Apellido</th>
                  <th>Correo</th>
                  <th>Telefono</th>
                  <th>Editar</th>
                  <th>Eliminar</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Patricia</td>
                  <td>Sanchez</td>
                  <td>3136513122</td>
                  <td>paty@gmail.com</td>
                  <td></td>
                  <td><FontAwesomeIcon icon="coffee"/></td>
                </tr>
                <tr>
                  <td>Alejandra</td>
                  <td>ortiz</td>
                  <td>326525659</td>
                  <td>aleortiz19@gmail.com</td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td>Jesus</td>
                  <td>Saldaña</td>
                  <td>326525659</td>
                  <td>elef@gmail.com</td>
                  <td></td>
                  <td></td>
                </tr>
              </tbody>
            </Table>
          </Row>
        </Container>
      </header>
    </div>
  );
}

export default App;
