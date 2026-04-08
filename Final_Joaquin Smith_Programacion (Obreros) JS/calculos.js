const tarifas = {
    Produccion: { tarifa_hora: 5.8, bonificacion: 15 },
    Envase: { tarifa_hora: 4.5, bonificacion: 12 },
    Almacen: { tarifa_hora: 4.0, bonificacion: 10 }
};

const datosEmpleados = [];

function calcularPagos() {
    const tabla = document.getElementById('tabla');
    const filas = tabla.getElementsByTagName('tr');
    let totalSoles = 0;
    let totalDolares = 0;

    for (let i = 1; i < filas.length; i++) {
        const celdas = filas[i].getElementsByTagName('td');
        const area = celdas[1].textContent;
        const horasTrabajadas = parseFloat(celdas[2].textContent);

        const tarifaHora = tarifas[area].tarifa_hora;
        const bonificacion = tarifas[area].bonificacion;

        const basico = tarifaHora * horasTrabajadas;
        const bono = (basico * bonificacion) / 100;
        const totalPagar = basico + bono;
        const essalud = basico * 0.06;
        const totalDolaresEmpleado = totalPagar / 3.75;

        celdas[3].textContent = basico.toFixed(2);
        celdas[4].textContent = bono.toFixed(2);
        celdas[5].textContent = totalPagar.toFixed(2);
        celdas[6].textContent = totalDolaresEmpleado.toFixed(2);
        celdas[7].textContent = essalud.toFixed(2);

        totalSoles += totalPagar - essalud;
        totalDolares += totalDolaresEmpleado;
    }

    const filaTotales = filas[filas.length - 1];

    if (filaTotales) {
        const celdaTotalSoles = filaTotales.cells[5];
        const celdaTotalDolares = filaTotales.cells[6];
        const celdaTotalEssalud = filaTotales.cells[7];

        celdaTotalSoles.textContent = 'Total a Pagar (Soles): ' + totalSoles.toFixed(2);
        celdaTotalDolares.textContent = 'Total a Pagar (Dólares): ' + totalDolares.toFixed(2);
        celdaTotalEssalud.textContent = 'Total Essalud: ' + (totalSoles * 0.06).toFixed(2);
    }
}

function agregarEmpleado() {
    const nombre = document.getElementById('nombre').value;
    const area = document.getElementById('area').value;
    const horasTrabajadas = parseFloat(document.getElementById('horas').value);

    if (!nombre || !area || isNaN(horasTrabajadas)) {
        alert('Por favor, ingrese datos válidos para el empleado.');
        return;
    }

    datosEmpleados.push([nombre, area, horasTrabajadas]);

    const tabla = document.getElementById('tabla');
    const fila = tabla.insertRow(-1);

    for (let i = 0; i < 8; i++) {
        const celda = fila.insertCell(-1);
        celda.textContent = (i < 3) ? datosEmpleados[datosEmpleados.length - 1][i] : '';
    }

    const celdas = fila.getElementsByTagName('td');
    const areaEmpleado = celdas[1].textContent;
    const horasTrabajadasEmpleado = parseFloat(celdas[2].textContent);

    const tarifaHora = tarifas[areaEmpleado].tarifa_hora;
    const bonificacion = tarifas[areaEmpleado].bonificacion;

    const basico = tarifaHora * horasTrabajadasEmpleado;
    const bono = (basico * bonificacion) / 100;
    const totalPagar = basico + bono;
    const essalud = basico * 0.06;
    const totalDolaresEmpleado = totalPagar / 3.75;

    celdas[3].textContent = basico.toFixed(2);
    celdas[4].textContent = bono.toFixed(2);
    celdas[5].textContent = totalPagar.toFixed(2);
    celdas[6].textContent = totalDolaresEmpleado.toFixed(2);
    celdas[7].textContent = essalud.toFixed(2);

    // Actualizar totales solo para el nuevo registro
    const filaTotales = tabla.getElementsByTagName('tr')[filas.length - 1];
    const celdaTotalSoles = filaTotales.cells[5];
    const celdaTotalDolares = filaTotales.cells[6];
    const celdaTotalEssalud = filaTotales.cells[7];

    const totalPagarNuevoEmpleado = totalPagar - essalud;
    const totalDolaresNuevoEmpleado = totalDolaresEmpleado;

    celdaTotalSoles.textContent = 'Total a Pagar (Soles): ' + totalPagarNuevoEmpleado.toFixed(2);
    celdaTotalDolares.textContent = 'Total a Pagar (Dólares): ' + totalDolaresNuevoEmpleado.toFixed(2);
    celdaTotalEssalud.textContent = 'Total Essalud: ' + (totalPagarNuevoEmpleado * 0.06).toFixed(2);
}

calcularPagos();  
