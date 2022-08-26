import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import java.time.LocalDateTime
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

/**
 * Fecha creacion : 08-04-2022
 * QA : Santiago Marrugo
 */
//Verificamos que se abra el popup de Asientos
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Asientos'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)
println("<------- ID 1 ------->")
//Obtenemos el valor del primer mes de asientos y lo guadamos en una variable para compararlo con el dato cuando ya estemos en la grilla del mes.
def String mesAsiento = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/LabelMesAsientoEnero2022'))
println(mesAsiento)
WebUI.delay(1)
WebUI.verifyElementPresent(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/LabelTituloPopupAsientos'), 5)
WebUI.delay(1)
//Seleccionamos la opcion editar mes
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputAnioAsiento'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputAnioAsiento'), '2022')
WebUI.delay(1)
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/DDOrdenadoPor'), '0', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonEditarMesAsiento'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesEnero2022'))
WebUI.delay(1)
WebUI.click(findTestObject('_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
//Obtenemos el valor de este label y extraemos la parte del mes de asiento que estamos viendo
def String asientoMes = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/LabelDentrodelAsiento'))
println(asientoMes)
asientoMes = asientoMes.substring(9, 15)
println(asientoMes)
//Verificamos que estemos en el mes de asiento seleccionado en el popup de Asientos
assert mesAsiento == asientoMes
WebUI.delay(1)

println("<------- ID 2 ------->")
//Ingresamos nuevamente al menu Asientos desde el menu lateral en la parte izquierda
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIzquierdoAsientos'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonCrearMesAsiento'))
WebUI.delay(1)
//Obtenemos la fecha actual, para extraer solo el mes y año y ese valor pasarlo como parametro al mes que vamos a crear
def String fechaCorriente = LocalDateTime.now()
println(fechaCorriente)
//2022-04-08T14:34:02.206
def String mes = fechaCorriente.substring(5, 7)
println(mes)
def String anio = fechaCorriente.substring(0, 4)
println(anio)
//Fecha que se va a pasar como parametro para crear el mes de asiento
def String fechaAsientoCrear = mes+"/"+anio
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputMesAnioAsiento'), fechaAsientoCrear)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(3)
def String asientoMesNuevo = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/LabelDentrodelAsiento'))
println(asientoMesNuevo)
asientoMesNuevo = asientoMesNuevo.substring(9, 16)
//Comprobamos el mes de asiento correcto
assert fechaAsientoCrear == asientoMesNuevo

println("<------- ID 8, 9 y 10  ------->")
//No ubicamos en la primera celda de la grilla
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
WebUI.delay(1)
//Obtenemos el valor de la primera celda, es decir en donde esta la celda seleccionada
def String primeraCelda = WebUI.executeJavaScript('return hot.getSelected()', null)
println(primeraCelda)
assert primeraCelda == '[[0, 5, 0, 5]]'
//Presionamos TAB y avanzamos 3 celdas hacia adelante
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.TAB))
WebUI.delay(1)
//Obtenemos el valor de la segunda celda, es decir en donde esta la celda seleccionada
def String segundaCelda = WebUI.executeJavaScript('return hot.getSelected()', null)
println(segundaCelda)
assert segundaCelda == '[[0, 6, 0, 6]]'
//Ahora nos devolvemos a la celda anterior con Shitf+Tab
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.SHIFT, Keys.TAB))
WebUI.delay(1)
def String celdaAnterior = WebUI.executeJavaScript('return hot.getSelected()', null)
println(celdaAnterior)
//Verificamos que se haya movido hacia la celda anterior
assert celdaAnterior == '[[0, 5, 0, 5]]'
WebUI.delay(1)

//Vamos a avanzar en la grilla por medio del ENTER
//Presionamos ENTER  3 veces
for(i=0;i<=2;i++) {
	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
	WebUI.delay(1)
}
def String celdaEnter = WebUI.executeJavaScript('return hot.getSelected()', null)
println(celdaEnter)
//Verificamos que se haya movido hacia adelante 3 veces
assert celdaEnter == '[[0, 8, 0, 8]]'
WebUI.delay(1)

//Seleccionamos la primera celda
println("<------- Desde aqui se van a realizar los ID 11 hasta ID 15 ------->")
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
WebUI.delay(1)
def String celdaInicial = WebUI.executeJavaScript('return hot.getSelected()', null)
println(celdaInicial)
assert celdaInicial == '[[0, 5, 0, 5]]'

//Procedemos a crear unos asientos para poder garantizar el funcionamiento de algunas de las opciones de la Toolbar
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Carpetas/Asientos/Crear Asiento - KW'),[:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)

println("<------- ID 7 ------->")
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
WebUI.delay(1)
//Vamos a navegar por la grilla con las telcas Inicio, Fin, RePag y AvPag
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.END))
WebUI.delay(1)
def String teclaFin = WebUI.executeJavaScript('return hot.getSelected()', null)
println(teclaFin)
assert teclaFin == '[[0, 21, 0, 21]]'

WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.HOME))
WebUI.delay(1)
def String teclaInicio = WebUI.executeJavaScript('return hot.getSelected()', null)
println(teclaInicio)
assert teclaInicio == '[[0, 5, 0, 5]]'

WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.PAGE_DOWN))
WebUI.delay(1)
def String teclaPageD = WebUI.executeJavaScript('return hot.getSelected()', null)
println(teclaPageD)
assert teclaPageD == '[[9, 5, 9, 5]]'

WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.PAGE_UP))
WebUI.delay(1)
def String teclaPageUP = WebUI.executeJavaScript('return hot.getSelected()', null)
println(teclaPageUP)
assert teclaPageUP == '[[0, 5, 0, 5]]'

//Despues de crear los asientos, nos posicionamos en el primera celda
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
WebUI.delay(1)

//Avanzamos dos casillas hacia abajo y comprobamos la celda
for (i=0; i<=1; i++) {
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonSiguienteDato'))
	WebUI.delay(1)
}
def String siguienteCelda = WebUI.executeJavaScript('return hot.getSelected()', null)
println(siguienteCelda)
assert siguienteCelda == '[[2, 5, 2, 5]]'

//Retrocedemos dos casillas hacia arriba y comprobamos la celda
for (i=0; i<=1; i++) {
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAnteriorDato'))
	WebUI.delay(1)
}
def String anteriorCelda = WebUI.executeJavaScript('return hot.getSelected()', null)
println(anteriorCelda)
assert anteriorCelda == '[[0, 5, 0, 5]]'

//Vamos a ir hasta el ultimo dato
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonUltimoDato'))
WebUI.delay(1)
def String ultimaCelda = WebUI.executeJavaScript('return hot.getSelected()', null)
println(ultimaCelda)
assert ultimaCelda == '[[9, 5, 9, 5]]'

//Vamos a ir hasta el primer dato
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonPrimerDato'))
WebUI.delay(1)
def String primerCelda = WebUI.executeJavaScript('return hot.getSelected()', null)
println(primerCelda)
assert primerCelda == '[[0, 5, 0, 5]]'

println("<------- ID 16  ------->")
//Hacemos clic en el boton filtrar y verificar que se muestre el popup
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonFiltrar'))
WebUI.delay(1)
WebUI.verifyTextPresent('Filtrar', false)
WebUI.delay(1)

println("<------- ID 17  ------->")
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCancelarPopupFiltrar'))
WebUI.delay(1)
def String celda = WebUI.executeJavaScript('return hot.getSelected()', null)
println(celda)
assert celda == '[[0, 5, 0, 5]]'
WebUI.delay(1)

println("<------- ID 18  ------->")
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonFiltrar'))
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputBuscasAsiento(Filtrar)'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputBuscasAsiento(Filtrar)'), 'entran')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarPopupFiltrar'))
WebUI.delay(1)
//Verificamos que este texto no este presente y de esa forma sabemos que si se realizo el filtro correctamente
WebUI.verifyTextNotPresent('Salen DOLARES dia 1', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCerrarValorFiltro'))
WebUI.delay(1)
WebUI.verifyTextPresent('Salen DOLARES dia 1', false)

println("<------- ID 19  ------->")
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonFiltrar'))
WebUI.delay(1)
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputBuscasAsiento(Filtrar)'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputBuscasAsiento(Filtrar)'), 'abcde')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarPopupFiltrar'))
WebUI.delay(1)
//Verificamos el mensaje de validacion cuando la busqueda no arroja resultados
WebUI.verifyTextPresent('No se encontró dato filtrado.', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCancelarPopupFiltrar'))
WebUI.delay(1)

println("<------- ID 20  ------->")
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIntegrarModeloAsiento'))
WebUI.delay(1)
//Verificamos que se muestre el popup para integrar el modelo.
WebUI.verifyTextPresent('Modelos de asientos', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCerrarPopupIntegrarModeloAsientos'))
WebUI.delay(1)

println("<------- ID 21 y 22 ------->")
//Verificamos que boton Consultar este activo solo cuando se este en la celdas DEBE, HABER, RUT, MONEDA, N, L, TIPO
def String isDisabled = WebUI.getAttribute(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'), 'class') 
println(isDisabled)
//Verificamos que el boton este desactivado
assert isDisabled == 'btnToolbarTest btn-toolbar-disabled'

//Avanzamos en las columnas para verificar el estado del boton Consultar
//Debe
WebUI.executeJavaScript('hot.selectCell(0,6)', null)
def String debe = WebUI.getAttribute(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'), 'class')
println(debe)
assert debe == 'btnToolbarTest'
//Click en el boton Consultar para que se muestre el popup
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'))
WebUI.delay(1)
WebUI.verifyTextPresent('Buscar:', false)
WebUI.delay(1)
WebUI.verifyTextPresent('1: ACTIVO', false)
WebUI.delay(1)
WebUI.verifyTextPresent('2: PASIVO', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCancelarPopupConsultar'))
WebUI.delay(1)

//Haber
WebUI.executeJavaScript('hot.selectCell(0,7)', null)
def String haber = WebUI.getAttribute(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'), 'class')
println(haber)
assert haber == 'btnToolbarTest'
//Click en el boton Consultar para que se muestre el popup
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'))
WebUI.delay(1)
WebUI.verifyTextPresent('Buscar:', false)
WebUI.delay(1)
WebUI.verifyTextPresent('1: ACTIVO', false)
WebUI.delay(1)
WebUI.verifyTextPresent('2: PASIVO', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCancelarPopupConsultar'))
WebUI.delay(1)

//RUT
WebUI.executeJavaScript('hot.selectCell(0,8)', null)
def String RUT = WebUI.getAttribute(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'), 'class')
println(RUT)
assert RUT == 'btnToolbarTest'
//Click en el boton Consultar para que se muestre el popup
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'))
WebUI.delay(1)
WebUI.verifyTextPresent('Clientes y proveedores', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCancelarPopupClientesProveedores'))
WebUI.delay(1)

//Moneda (M)
WebUI.executeJavaScript('hot.selectCell(0,11)', null)
def String moneda = WebUI.getAttribute(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'), 'class')
println(moneda)
assert moneda == 'btnToolbarTest'
//Click en el boton Consultar para que se muestre el popup
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'))
WebUI.delay(1)
WebUI.verifyTextPresent('Monedas', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCancelarPopupMonedas'))
WebUI.delay(1)

//N
WebUI.executeJavaScript('hot.selectCell(0,13)', null)
def String N = WebUI.getAttribute(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'), 'class')
println(N)
assert N == 'btnToolbarTest'
//Click en el boton Consultar para que se muestre el popup
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'))
WebUI.delay(1)
WebUI.verifyTextPresent('Impuestos y percepciones', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCancelarPopupImpuestosPercepciones'))
WebUI.delay(1)

//Libro (L)
WebUI.executeJavaScript('hot.selectCell(0,19)', null)
def String libro = WebUI.getAttribute(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'), 'class')
println(libro)
assert libro == 'btnToolbarTest'
//Click en el boton Consultar para que se muestre el popup
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'))
WebUI.delay(1)
WebUI.verifyTextPresent('Libros', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCancelarPopupLibros'))
WebUI.delay(1)

//Tipo
WebUI.executeJavaScript('hot.selectCell(0,21)', null)
def String tipo = WebUI.getAttribute(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'), 'class')
println(tipo)
assert tipo == 'btnToolbarTest'
//Click en el boton Consultar para que se muestre el popup
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonConsultar'))
WebUI.delay(1)
WebUI.verifyElementPresent(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/InputBuscarTipo'), 5)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCancelarPopupTipo'))
WebUI.delay(1)

println("<------- ID 23, 24  ------->")
WebUI.executeJavaScript('hot.selectCell(9,5)', null)
WebUI.delay(1)
//Agregamos una nueva fila
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
//Verificamos que se haya creado la nueva linea de asiento
def String filaAgregada = WebUI.executeJavaScript('return hot.getSelected()', null)
println(filaAgregada)
assert filaAgregada == '[[10, 5, 10, 5]]'
//Eliminamos la linea agregada
WebUI.click(findTestObject('_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
WebUI.delay(1)

println("<------- ID 25, 26  ------->")
WebUI.executeJavaScript('hot.selectCell(9,5)', null)
//Hacemos clic en el boton copiar
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCopiarLinea'))
WebUI.delay(1)
//Hacemoc clic en el boton pegar
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonPegarLinea'))
WebUI.delay(1)
//Seleccionamos la celda copiada y verificamos su contenido sea igual al de la celda original copiada
WebUI.executeJavaScript('hot.selectCell(10,10)', null)
WebUI.delay(1)
def String celdaCopiada = WebUI.executeJavaScript('return hot.getValue()', null)
println(celdaCopiada)
assert celdaCopiada == 'Salen DOLARES dia 5'
WebUI.delay(1)
//Eliminamos la linea agregada
WebUI.click(findTestObject('_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
WebUI.delay(1)
//Para verificar que la linea agregada hay sido eliminada correctamente, nos vamos al ultimo registro y nos aseguramos que sea [[9, 5, 9, 5]]
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonUltimoDato'))
WebUI.delay(1)
def String actual = WebUI.executeJavaScript('return hot.getSelected()', null)
println(actual)
assert actual == '[[9, 5, 9, 5]]'

println("<------- ID 31 ------->")
//Ingresamos un numero de cuenta contable al Debe que no existe, debe saltar un popup para crear la cuenta
WebUI.executeJavaScript('hot.selectCell(9,5)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(10,6)', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(10,6,"123456789")', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(10,7)', null)
WebUI.delay(1)
//Verificamos que se muestre el popup
WebUI.verifyTextPresent('Crear Cuenta', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonCancelarPopupCrearCuenta'))

println("<------- ID 32 ------->")
/**
 * El popup para confirmar que si queremos crear el Cliente no sale
 */
////Ingresamos un numero de RUT que no existe, debe saltar un popup para crear el RUT
//WebUI.executeJavaScript('hot.selectCell(10,8)', null)
//WebUI.delay(1)
//WebUI.executeJavaScript('hot.setDataAtCell(10,8,"123456789")', null)
//WebUI.delay(1)
//WebUI.executeJavaScript('hot.selectCell(10,9)', null)
//WebUI.delay(1)



//Borrar linea
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(9,5)', null)

println("<------- ID 27 ------->")
//Procedemos a imprimir los asientos registrados en el mes actual
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonImprimir'))
WebUI.delay(3)
WebUI.verifyElementPresent(findTestObject('_Conty/Menu Principal/Carpetas/Asientos/BotonZoomEnImprimirExportar'), 3)
WebUI.delay(1)
WebUI.verifyElementPresent(findTestObject('_Conty/Menu Principal/Carpetas/Asientos/LabelAsientosImprimirExportar'), 10, FailureHandling.CONTINUE_ON_FAILURE )
WebUI.delay(1)

//Seleccionamos todas las filas del mes de asiento para eliminarlas, para efectos de la regresion, ya que cada vez que se corra el mes de asiento
//sera creado.
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonIzquierdoAsientos'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/RadioButtonMesCorriente'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarAsientos'))
WebUI.delay(3)
WebUI.executeJavaScript('hot.selectRows(0,9)', null)
WebUI.delay(1)
WebUI.click(findTestObject('_Conty/Menu Principal/Carpetas/Asientos/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonAceptarBorrarAsientos'))
WebUI.delay(1)
WebUI.verifyTextNotPresent('11111', false)
WebUI.delay(1)
WebUI.verifyTextNotPresent('11112', false)
WebUI.delay(1)

WebUI.executeJavaScript("alert('AQUI TERMINA EL TEST')", null)
WebUI.delay(3)

WebUI.closeBrowser()
