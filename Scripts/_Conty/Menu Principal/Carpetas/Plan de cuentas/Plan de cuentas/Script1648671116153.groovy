import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import java.io.File
import java.time.LocalDateTime
import java.util.Date
import java.util.Calendar

/**
 * Fecha creacion : 30-03-2022
 * QA : Santiago Marrugo
 */
//Iniciamos sesion en la plataforma Conty
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Plan de Cuentas'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)

//Verificamos que existan las 9 columnas, y lo hacemos por medio de los nombre de las mismas
def String colCodigo = WebUI.executeJavaScript('return hot.getColHeader(1)', null)
println(colCodigo)
assert colCodigo == 'Código'
def String colNombre = WebUI.executeJavaScript('return hot.getColHeader(2)', null)
println(colNombre)
assert colNombre == 'Nombre'
def String colMonedaBase = WebUI.executeJavaScript('return hot.getColHeader(3)', null)
println(colMonedaBase)
assert colMonedaBase == 'Moneda base'
def String colOperaEn = WebUI.executeJavaScript('return hot.getColHeader(4)', null)
println(colOperaEn)
assert colOperaEn == 'Opera en'
def String colMonedaDC = WebUI.executeJavaScript('return hot.getColHeader(5)', null)
println(colMonedaDC)
assert colMonedaDC == 'Moneda (DC)'
def String colCategoria = WebUI.executeJavaScript('return hot.getColHeader(8)', null)
println(colCategoria)
assert colCategoria == 'Categoria'
def String colSubcategoria = WebUI.executeJavaScript('return hot.getColHeader(9)', null)
println(colSubcategoria)
assert colSubcategoria == 'SubCategoria'
def String colBanco = WebUI.executeJavaScript('return hot.getColHeader(10)', null)
println(colBanco)
assert colBanco == 'Banco'
def String colTarjeta = WebUI.executeJavaScript('return hot.getColHeader(11)', null)
println(colTarjeta)
assert colTarjeta == 'Tarjeta'

//Se navega por la grilla usando las teclas de navegacion del teclado, arriba, abajo, derecha e izquierda
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
def String celdaDer = WebUI.executeJavaScript('return hot.getSelected()', null)
//aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
assert celdaDer == '[[0, 2, 0, 2]]'
println(celdaDer)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
def String celdaAba = WebUI.executeJavaScript('return hot.getSelected()', null)
//aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
assert celdaAba == '[[1, 2, 1, 2]]'
println(celdaAba)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_LEFT))
def String celdaIzq = WebUI.executeJavaScript('return hot.getSelected()', null)
//aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
assert celdaIzq == '[[1, 1, 1, 1]]'
println(celdaIzq)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_UP))
def String celdaArr = WebUI.executeJavaScript('return hot.getSelected()', null)
//aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
assert celdaArr == '[[0, 1, 0, 1]]'
println(celdaArr)

//Se navega hacia la derecha con la tecla TAB
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.TAB))
def String tabDer = WebUI.executeJavaScript('return hot.getSelected()', null)
//aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
assert tabDer == '[[0, 2, 0, 2]]'
println(tabDer)

//Se navega hacia la izquierda con la tecla Shift+Tab
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.SHIFT, Keys.TAB))
def String tabIzq = WebUI.executeJavaScript('return hot.getSelected()', null)
//aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
assert tabIzq == '[[0, 1, 0, 1]]'
println(tabIzq)

//Se navega con la tecla ENTER
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
def String celdaEnter1 = WebUI.executeJavaScript('return hot.getSelected()', null)
//Aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
assert celdaEnter1 == '[[0, 2, 0, 2]]'
println(celdaEnter1)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
def String celdaEnter2 = WebUI.executeJavaScript('return hot.getSelected()', null)
//Aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
assert celdaEnter2 == '[[0, 3, 0, 3]]'
println(celdaEnter2)

//Hacemos click en el boton Siguiente dato
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonSiguienteDato'))
def String celdaSigDato = WebUI.executeJavaScript('return hot.getSelected()', null)
println(celdaSigDato)
//Aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
assert celdaSigDato == '[[1, 3, 1, 3]]'

//Hacemos click en el boton Siguiente dato
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAnteriorDato'))
def String celdaAntDato = WebUI.executeJavaScript('return hot.getSelected()', null)
println(celdaAntDato)
//Aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
assert celdaAntDato == '[[0, 3, 0, 3]]'

//Se navega con la tecla PAGE_DOWN
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.PAGE_DOWN))
WebUI.delay(2)
//Verificamos que se haya movido el cursor despues de presionar la tecla PAGE_DOWN
def paginaAba= WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/LabelCantidadRegistros'))
println(paginaAba)
assert paginaAba == '35 / 100'

//Se navega con la tecla PAGE_UP
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.PAGE_UP))
WebUI.delay(2)
//Verificamos que se haya movido el cursor despues de presionar la tecla PAGE_UP
def paginaArri= WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/LabelCantidadRegistros'))
println(paginaArri)
assert paginaArri == '1 / 100'

//Hacemos scroll hacia abajo y despues hacia arriba
for (i=0; i<2; i++) {
	WebUI.executeJavaScript('document.getElementsByClassName("wtHolder")[0].scrollTop=50*23+23', null)
	WebUI.delay(1)
}

//Se abre el popup de Buscar con Shift+F8
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.SHIFT, Keys.F8))
WebUI.delay(1)
//Cerramos el pop
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonCancelarPopUpBuscar'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonBuscar'))
WebUI.delay(1)
//Verificamos que se abra el pop
WebUI.verifyTextPresent('Buscar', false)
WebUI.delay(1)
//Cerramos el pop
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonCancelarPopUpBuscar'))
WebUI.delay(1)
//Buscamos una cuenta que exista
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonBuscar'))
WebUI.delay(1)
//Verificamos que se abra el pop
WebUI.verifyTextPresent('Buscar', false)
WebUI.delay(1)
//Buscamos una cuenta por medio de una palabra clave
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarCuenta'))
WebUI.delay(1)
/**
 * En esta parte de buscar, solo se realiza en la primera pagina
 */
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarCuenta'), 'venta')
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarPopUpBuscar'))
WebUI.delay(1)
//Validamos que la busqueda haya sido existosa, si este mensaje no sale es porque la busqueda arrojo resultados.
WebUI.verifyTextNotPresent('No se encontró dato buscado.', false)

//Se hace click dos veces en el mismo boton debido a que en el primer click se borra la busqueda anterior y en el segundo se abre el popup
for (int x=0; x<=1; x++) {
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonBuscar'))
	WebUI.delay(1)
}

//Hacemos una busqueda que no arroje resultados y se valida el mensaje respectivo
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarCuenta'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarCuenta'), 'abcd')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarPopUpBuscar'))
WebUI.delay(1)
//Validamos que la busqueda haya NO haya sido existosa, si este mensaje sale es porque la busqueda NO arrojo resultados.
WebUI.verifyTextPresent('No se encontró dato buscado.', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonCancelarPopUpBuscar'))
WebUI.delay(1)

//Verificamos antes que el campo consultar no sea cliqueable
def desactivado = WebUI.getAttribute(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonConsultar'), 'class')
println(desactivado)
assert desactivado == 'btnToolbarTest btn-toolbar-disabled'
WebUI.delay(1)

//Hacemos clic en la grilla en los campos, <<Moneda base, Opera en y Moneda DC>> y el boton consultar debe activarse al momento de ubicarnos en algunas de estas e celdas
//Click en celda MONEDA BASE
WebUI.executeJavaScript('hot.selectCell(0,3)', null)
def activado = WebUI.getAttribute(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonConsultar'), 'class')
println(activado)
assert activado == 'btnToolbarTest'
WebUI.delay(1)
//Click en celda OPERA EN
WebUI.executeJavaScript('hot.selectCell(0,4)', null)
def activado_2 = WebUI.getAttribute(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonConsultar'), 'class')
println(activado_2)
assert activado_2 == 'btnToolbarTest'
WebUI.delay(1)
//Click en celda MONEDA DC
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
def activado_3 = WebUI.getAttribute(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonConsultar'), 'class')
println(activado_3)
assert activado_3 == 'btnToolbarTest'
WebUI.delay(1)

//Click en celda MONEDA BASE, para buscar este codigo y que la funcion de buscar este correcta
//Aqui vamos a buscar el mismo codigo de moneda que esta en la celda, en este caso 0 (cero)
WebUI.executeJavaScript('hot.selectCell(0,3)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonConsultar'))
WebUI.delay(1)
//Verificamos que se abra la ventana correspondiente
WebUI.verifyTextPresent('Monedas', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarMonedaBase'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarMonedaBase'), 'pesos')
WebUI.delay(1)
WebUI.verifyTextPresent('Pesos', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarMonedas'))
WebUI.delay(1)

//Click en celda OPERA EN, para buscar este codigo y que la funcion de buscar este correcta
WebUI.executeJavaScript('hot.selectCell(0,4)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonConsultar'))
WebUI.delay(1)
//Verificamos que se abra la ventana correspondiente
WebUI.verifyTextPresent('Pesos', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarMonedaOperaEn'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarMonedaOperaEn'), 'pesos')
WebUI.delay(1)
WebUI.verifyTextPresent('Pesos', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/CheckPesosOpEn'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarMonedaOperaEn'))
WebUI.delay(1)

//Click en celda MONEDA DC, para buscar este codigo y que la funcion de buscar este correcta
WebUI.executeJavaScript('hot.selectCell(0,5)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonConsultar'))
WebUI.delay(1)
//Verificamos que se abra la ventana correspondiente
WebUI.verifyTextPresent('Monedas', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarMoneda(DC)'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarMoneda(DC)'), 'dolares')
WebUI.delay(1)
WebUI.verifyTextPresent('Dolares', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/CheckDolaresMonDC'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarMoneda(DC)'))
WebUI.delay(1)

//Navego desde el primer registro hasta el ultimo
//UD = Ultimo Dato
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonUltimoDato'))
WebUI.delay(1)
def numRegistros_UD= WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/LabelCantidadRegistros'))
String registros_UD = numRegistros_UD
println(registros_UD)
//Obtengo el valor de la celda donde esta el cursosr o foco, que en este caso deberia ser la ultima
def String ultimaCelda_UD = registros_UD.substring(0, 3)
println(ultimaCelda_UD)
//Obtengo el valor total de los registros
def String totalRegistros_UD = registros_UD.substring(6, 9)
println(totalRegistros_UD)
//Los comparo y si son iguales quiere decir que estoy en la ultima celda de la grilla
assert ultimaCelda_UD == totalRegistros_UD
WebUI.delay(1)

//Navego desde el ultimo registro
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonPrimerDato'))
WebUI.delay(1)
def numRegistros_PD= WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/LabelCantidadRegistros'))
String registros_PD = numRegistros_PD
println(registros_PD)
//Obtengo el valor de la celda donde esta el cursosr o foco, que en este caso deberia ser la primera
def primeraCelda = registros_PD.substring(0, 1)
println(primeraCelda)
//Verifico que la celda seleccionada sea la numero 1
assert primeraCelda == '1'

//Aqui se procede a imprimir el plan de cuentas
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonImprimir'))
WebUI.delay(5)
//Titulo de la vista previa del reporte
WebUI.back()
//Titulo de la ventana
WebUI.verifyTextPresent('Plan de cuentas', false)

//Vamos a guardar el plan de cuenta con errores y verificar que se muestre el mensaje respectivo
//Nos ubicamos en la fila 1 columna 1
WebUI.executeJavaScript('hot.selectCell(0,1)', null)
WebUI.delay(1)
//Primero agregamos una nueva linea y escribimos un dato en una sola celda
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonNuevaLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(1,1, "11111199999")', null)
WebUI.delay(1)
WebUI.verifyTextPresent('11111199999', false)
//Vamos a guardar la linea con errores para que nos arroje el popup indicando que hay un error
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonTerminar'))
WebUI.delay(1)
//PopUp aviso de errores
WebUI.verifyTextPresent('Se detectaron errores en la validación del plan de cuentas.', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonSIAvisoErrores'))
//Eliminamos la linea con errores
//Nos ubicamos en la fila 2 columna 1
WebUI.executeJavaScript('hot.selectCell(1,1)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonEliminarLinea'))
WebUI.delay(1)
//Eliminamos la linea
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarBorrarCuenta'))
WebUI.delay(1)
WebUI.verifyTextNotPresent('11111199999', false)

//Vamos a guardar el plan de cuenta sin errores
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonTerminar'))
WebUI.delay(1)
//Verificamos que estemos en el inicio despues de guardar exitosamente el Plan de Cuentas
WebUI.verifyTextPresent('Inicio', false)
WebUI.delay(1)

//Abrimos nuevamente el plan de cuentas
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonIzquierdoCuentas'))
WebUI.delay(5)

//Procedemos a Copia y Pegar una linea
WebUI.executeJavaScript('hot.selectCell(0,2)', null)
WebUI.delay(1)
//Obtengo los datos dentro de la celda que se va a copiar
def String datoCeldaOriginal = WebUI.executeJavaScript('return hot.getValue(0,2)', null)
println(datoCeldaOriginal)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonCopiarLinea'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonPegarLinea'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(1,2)', null)
WebUI.delay(1)
//Obtengo los datos dentro de la celda copiada
def String datoCeldaCopiada = WebUI.executeJavaScript('return hot.getValue(1,2)', null)
println(datoCeldaCopiada)
//Se comparan los dos valores y de esa forma nos aseguramos que se haya copiado correctamente
assert datoCeldaOriginal == datoCeldaCopiada
WebUI.delay(1)
//Despues de copiadas, pegadas y comparadas, se procede a eliminar dicha linea
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.verifyTextPresent('Borrar cuenta', false)
WebUI.delay(1)
WebUI.verifyTextPresent('¿Está seguro que quiere borrar la cuenta seleccionada?', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarBorrarCuenta'))
WebUI.delay(1)
WebUI.executeJavaScript("alert('******** AQUI TERMINA EL TEST ********')", null)
WebUI.delay(3)
WebUI.closeBrowser()

