const React = require('react');
const client = require('../client');
const { Link, useParams} = require('react-router-dom');
const {useState, useEffect} = require('react');



const PageVerBanda = (props) => {

    let { id } = useParams();
    const [banda, setBanda] = useState({});
    // const [integrantes, setIntegrantes] = useState([]);


    useEffect(() => {
        client({
            method: 'GET',
            path: '/api/bandas/' + id
        }).done(response => {
            setBanda(response.entity);
        });


    }, []);


    return (
        <>
            <h1>Banda</h1>
            <table>
                <tbody>
                    <tr>
                        <th>Nombre</th>
                        <td>{banda.nombre}</td>
                    </tr>
                </tbody>
            </table>

            <Link to="/">Volver</Link>
        </>
    )
}

module.exports = PageVerBanda;