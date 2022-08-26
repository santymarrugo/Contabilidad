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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import org.openqa.selenium.Keys as Keys
import java.io.File
import java.util.Date
import java.time.LocalDateTime
import java.util.Calendar
import java.lang.Float as Float

/**
 * Fecha : 25-03-2022
 * QA :  Santiago Marrugo
 *
 */

//Iniciamos sesion en la plataforma Conty
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Plan de Cuentas'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)

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
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarCuenta'), 'venta')
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarPopUpBuscar'))
WebUI.delay(1)
//Validamos que la busqueda haya sido existosa, si este mensaje no sale es porque la busqueda arrojo resultados.
WebUI.verifyTextNotPresent('No se encontró dato buscado.', false)
//println(LocalDateTime.now())
////Se obtiene la fecha actual con la hora
//def String fechaSinFormato = LocalDateTime.now()
////Sacamos la fecha aparte
//String fecha = fechaSinFormato.substring(0, 10)
//println(fecha)
////Se le cambia el guion por vacio
//fecha = fecha.replace('-', '')
//println(fecha)
//
////Sacamos la hora aparte
//String hora = fechaSinFormato.substring(11, 16)
//println(hora)
////Se le cambia el guion por vacio
//hora = hora.replace(':', '')
//println(hora)
//
//println('PlanDeCuentas_'+fecha+'_'+hora+'.pdf')

////Nos ubicamos en la fila 1 columna 1
//WebUI.executeJavaScript('hot.selectCell(0,1)', null)
//WebUI.delay(2)
////Primero agregamos una nueva linea y escribimos un dato en una sola celda
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonNuevaLinea'))
//WebUI.delay(2)
//WebUI.executeJavaScript('hot.setDataAtCell(1,1, "11111199999")', null)
//WebUI.delay(2)
//WebUI.verifyTextPresent('11111199999', false)
////Vamos a guardar la linea con errores para que nos arroje el popup indicando que hay un error
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonTerminar'))
//WebUI.delay(2)
////PopUp aviso de errores
//WebUI.verifyTextPresent('Se detectaron errores en la validación del plan de cuentas.', false)
//WebUI.delay(2)
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonSIAvisoErrores'))
////Eliminamos la linea con errores
////Nos ubicamos en la fila 2 columna 1
//WebUI.executeJavaScript('hot.selectCell(1,1)', null)
//WebUI.delay(2)
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonEliminarLinea'))
//WebUI.delay(2)
////Eliminamos la linea
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarBorrarCuenta'))
//WebUI.delay(2)
//WebUI.verifyTextNotPresent('11111199999', false)

//WebUI.executeJavaScript('hot.selectCell(0,2)', null)
//def String datoCelda = WebUI.executeJavaScript('return hot.getValue(0,2)', null)
//println(datoCelda)
//println(WebUI.executeJavaScript('hot.getCoords(hot.getCell(0, 2))', null))
//println(WebUI.executeJavaScript('document.getElementsByClassName("current highlightr")', null))
//println(WebUI.executeJavaScript('document.getElementsByClassName("current highlightr")[0].value', null))
//println(WebUI.executeJavaScript('event.ctrlKey', null))

//WebElement element = WebUI.executeJavaScript("document.getElementsByClassName('wtHolder')[0];", null)
//
//println(element)


//Procedemos a Copia y Pegar una linea
//WebUI.executeJavaScript('hot.selectCell(0,2)', null)
//WebUI.delay(2)
////Obtengo los datos dentro de la celda que se va a copiar
//def String datoCeldaOriginal = WebUI.executeJavaScript('return hot.getValue(0,2)', null)
//println(datoCeldaOriginal)
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonCopiarLinea'))
//WebUI.delay(2)
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonPegarLinea'))
//WebUI.delay(2)
//WebUI.executeJavaScript('hot.selectCell(1,2)', null)
//WebUI.delay(2)
////Obtengo los datos dentro de la celda copiada
//def String datoCeldaCopiada = WebUI.executeJavaScript('return hot.getValue(1,2)', null)
//println(datoCeldaCopiada)
////Se comparan los dos valores y de esa forma nos aseguramos que se haya copiado correctamente
//assert datoCeldaOriginal == datoCeldaCopiada
//WebUI.delay(2)
////Despues de copiadas, pegadas y comparadas, se procede a eliminar dicha linea
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonEliminarLinea'))
//WebUI.delay(2)
//WebUI.verifyTextPresent('Borrar cuenta', false)
//WebUI.delay(2)
//WebUI.verifyTextPresent('¿Está seguro que quiere borrar la cuenta seleccionada?', false)
//WebUI.delay(2)
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarBorrarCuenta'))
//WebUI.delay(2)
//for (i=0; i<2; i++) {
//	WebUI.executeJavaScript('document.getElementsByClassName("wtHolder")[0].scrollTop=50*23+23', null)
//	WebUI.delay(1)
//}
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.SHIFT, Keys.F8))
//WebUI.executeJavaScript('hot.selectCell(0,1)', null)
//def celda1 = WebUI.executeJavaScript('return hot.getValue(0,1)', null)
//def float celda1_F = Float.parseFloat(celda1)
//println(celda1_F)
//
//WebUI.executeJavaScript('hot.selectCell(1,1)', null)
//def celda2 = WebUI.executeJavaScript('return hot.getValue(1,1)', null)
//def float celda2_F = Float.parseFloat(celda2)
//println(celda2_F)
//
//def resultado = celda1_F + celda2_F
//
//println(resultado)

//	WebUI.delay(1)
//	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
//	WebUI.delay(2)
//	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//	WebUI.delay(2)
//	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_LEFT))
//	WebUI.delay(2)
//	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_UP))

//Se navega por la grilla usando las teclas de navegacion del teclado, arriba, abajo, derecha e izquierda
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//def String celdaDer = WebUI.executeJavaScript('return hot.getSelected()', null)
////aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
//assert celdaDer == '[[0, 2, 0, 2]]'
//println(celdaDer)
//
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_DOWN))
//def String celdaAba = WebUI.executeJavaScript('return hot.getSelected()', null)
////aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
//assert celdaAba == '[[1, 2, 1, 2]]'
//println(celdaAba)
//
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_LEFT))
//def String celdaIzq = WebUI.executeJavaScript('return hot.getSelected()', null)
////aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
//assert celdaIzq == '[[1, 1, 1, 1]]'
//println(celdaIzq)
//
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_UP))
//def String celdaArr = WebUI.executeJavaScript('return hot.getSelected()', null)
////aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
//assert celdaArr == '[[0, 1, 0, 1]]'
//println(celdaArr)
//
////Se navega hacia la derecha con la tecla TAB
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.TAB))
//def String tabDer = WebUI.executeJavaScript('return hot.getSelected()', null)
////aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
//assert tabDer == '[[0, 2, 0, 2]]'
//println(tabDer)
//
////Se navega hacia la izquierda con la tecla Shift+Tab
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.SHIFT, Keys.TAB))
//def String tabIzq = WebUI.executeJavaScript('return hot.getSelected()', null)
////aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
//assert tabIzq == '[[0, 1, 0, 1]]'
//println(tabIzq)
//WebUI.delay(2)
//
////Se navega con la tecla ENTER
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String celdaEnter1 = WebUI.executeJavaScript('return hot.getSelected()', null)
////Aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
//assert celdaEnter1 == '[[0, 2, 0, 2]]'
//println(celdaEnter1)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ENTER))
//def String celdaEnter2 = WebUI.executeJavaScript('return hot.getSelected()', null)
////Aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
//assert celdaEnter2 == '[[0, 3, 0, 3]]'
//println(celdaEnter2)
//
////Hacemos click en el boton Siguiente dato
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonSiguienteDato'))
//def String celdaSigDato = WebUI.executeJavaScript('return hot.getSelected()', null)
//println(celdaSigDato)
////Aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
//assert celdaSigDato == '[[1, 3, 1, 3]]'
//
////Hacemos click en el boton Siguiente dato
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAnteriorDato'))
//def String celdaAntDato = WebUI.executeJavaScript('return hot.getSelected()', null)
//println(celdaAntDato)
////Aqui se evalua que la celda seleccionada sea la correcta, funciona [PrimeraFila, PrimeraColumna, UltimaFila, UltimaColumna]
//assert celdaAntDato == '[[0, 3, 0, 3]]'

//Verificamos con los datos de la celda, de que si se haya cambiado de celda, moviendonos desde la derecha, abajo, izquierda y arriba
//assert celdaDer != celdaArr
//assert celdaIzq != celdaAba
//
////Se navega hacia la derecha con la tecla TAB
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.TAB))
//WebUI.executeJavaScript('hot.setDataAtCell(0,2, "Valorcelda TAB 0,2")', null)
//def String tabDer = WebUI.executeJavaScript('return hot.getValue(0,2)', null)
//println(tabDer)
//
////Se navega hacia la izquierda con la tecla Shift+Tab
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.SHIFT, Keys.TAB))
//WebUI.executeJavaScript('hot.setDataAtCell(0,0, "1")', null)
//def String tabIzq = WebUI.executeJavaScript('return hot.getValue(0,2)', null)
//println(tabIzq)
////Se verifica que los valores sean diferentes despues de haber navegado entre las celdas y haber cambiado sus valores
//assert tabDer != tabIzq



////Se navega con la tecla PAGE_DOWN
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.PAGE_DOWN))
//WebUI.delay(2)
////Verificamos que se haya movido el cursor despues de presionar la tecla PAGE_DOWN
//def paginaAba= WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/LabelCantidadRegistros'))
//println(paginaAba)
//assert paginaAba == '35 / 100'
//
////Se navega con la tecla PAGE_UP
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.PAGE_UP))
//WebUI.delay(2)
////Verificamos que se haya movido el cursor despues de presionar la tecla PAGE_UP
//def paginaArri= WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/LabelCantidadRegistros'))
//println(paginaArri)
//assert paginaArri == '1 / 100'
//
////for (i=0; i<=2; i++) {
////	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.PAGE_DOWN))
////	WebUI.delay(1)
////}
////for (i=0; i<=2; i++) {
////	WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.PAGE_UP))
////	WebUI.delay(1)
////}
//WebUI.executeJavaScript('hot.selectCell(0,2)', null)
//def String coordenadas = WebUI.executeJavaScript('return hot.getSelected()', null)
//println(coordenadas)

//[[startRow, startCol, endRow, endCol],...].
