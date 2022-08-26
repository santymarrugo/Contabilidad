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

/**
 * Fecha : 07-04-2022
 * QA :  Santiago Marrugo
 *
 */

//Iniciamos sesion en la plataforma Conty
WebUI.callTestCase(findTestCase('_Conty/Menu Principal/Accesos a menu principal/Acceso a Plan de Cuentas'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.delay(2)

//Se crear estos clousers para optimizar el codigo y no repetirlo a lo largo del test
_guadarPlanExitoso = {
	//Guardamos la creacion de la nueva cuenta
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonTerminar'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('Inicio', false)
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonIzquierdoCuentas'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('Plan de cuentas', false)
	WebUI.delay(1)
}
_borrarLinea = {
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonEliminarLinea'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarBorrarCuenta'))
	WebUI.delay(1)
}
_verificarCeldaAgregada = {
	//Nos ubicamos nuevamente en la celda numero 1
	WebUI.executeJavaScript('hot.selectCell(0,1)', null)
	WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonNuevaLinea'))
	WebUI.delay(1)
	def String filaCodCuenta = WebUI.executeJavaScript('return hot.getSelected()', null)
	println(filaCodCuenta)
	assert filaCodCuenta == '[[1, 1, 1, 1]]'
	WebUI.delay(1)
}

//ID 1
println("<------ ID 1 ------>")
//Agregamos una nueva fila para crear una cuenta contable
_verificarCeldaAgregada.call()
WebUI.executeJavaScript('hot.setDataAtCell(1,1,"11118")', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(1,2,"PRUEBACTAOK")', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(1,3,"0")', null)
WebUI.delay(1)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.TAB))
WebUI.delay(1)
//Guardamos la creacion de la nueva cuenta
_guadarPlanExitoso.call()
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonIzquierdoCuentas'))
WebUI.delay(1)
WebUI.verifyTextPresent('Plan de cuentas', false)
WebUI.delay(1)
//Buscamos la cuenta con el codigo para ver si aparece en la grilla
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonBuscar'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarCuenta'), '11118')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarPopUpBuscar'))
WebUI.delay(1)
//Verificamos si este la cuenta
WebUI.verifyTextPresent('11118', false)
WebUI.delay(1)
WebUI.verifyTextPresent('PRUEBACTAOK', false)
WebUI.delay(1)
//Para efectos del test se elimina la cuenta anteriormente creada, para crearla nuevamente cada vez que se ejecute la prueba de regresion
_borrarLinea.call()
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonBuscar'))
WebUI.delay(1)
//Verificamos NO este la cuenta, despues de eliminada
WebUI.verifyTextNotPresent('11118', false)
WebUI.delay(1)
WebUI.verifyTextNotPresent('PRUEBACTAOK', false)
//Buscamos la cuenta con el codigo para ver si aparece en la grilla despues de eliminada, NO deberia aparecer
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonBuscar'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarCuenta'), '11118')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarPopUpBuscar'))
WebUI.delay(1)
WebUI.verifyTextPresent('No se encontró dato buscado.', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonCancelarPopUpBuscar'))
WebUI.delay(1)

//ID 2
println("<------ ID 2 ------>")
//Agregamos una nueva fila para crear una cuenta contable
_verificarCeldaAgregada.call()
//Nos pasamos a la celda del nombre y dejamos el codigo vacio
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.TAB))
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(1,2,"PRUEBASINCOD")', null)
WebUI.delay(1)
//Al pasar a la siguiente nos debe saltar un popup informando que el codigo no puede estar vacio
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.TAB))
WebUI.delay(1)
WebUI.verifyTextPresent('El código contable no puede estar vacío.', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarVentanaAviso'))
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(1,3,"0")', null)
WebUI.delay(1)
//Guardamos la nueva cuenta SIN codigo
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonTerminar'))
WebUI.delay(1)
//PopUp aviso de errores
WebUI.verifyTextPresent('Se detectaron errores en la validación del plan de cuentas.', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonSIAvisoErrores'))
WebUI.delay(1)
//Eliminamos la linea
//Para efectos del test se elimina la cuenta anteriormente creada puesto que tiene errores
_borrarLinea.call()
//Guardamos el plan de cuenta
_guadarPlanExitoso.call()
WebUI.delay(1)

//ID 3
//println("<------ ID 3 ------>")
////Agregamos una nueva fila para crear una cuenta contable
//_verificarCeldaAgregada.call()
//WebUI.executeJavaScript('hot.setDataAtCell(1,1,"1111111")', null)
//WebUI.delay(1)
//WebUI.executeJavaScript('hot.setDataAtCell(1,2,"PRUEBASINMONEDA")', null)
//WebUI.delay(1)
//WebUI.executeJavaScript('hot.selectCell(1,3)', null)
//WebUI.delay(1)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.DELETE))
//WebUI.delay(1)
//WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//def String valorMoneda = WebUI.executeJavaScript('return hot.getValue(1,3)', null) 
//println(valorMoneda)
////Validamos que en realidad la celda de la moneda este vacia, en ese caso devuelve un null
//assert valorMoneda == null
////Guardamos la nueva cuenta SIN Moneda base
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonTerminar'))
//WebUI.delay(1)
////PopUp aviso de errores
//WebUI.verifyTextPresent('Se detectaron errores en la validación del plan de cuentas.', false)
//WebUI.delay(1)
//WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonSIAvisoErrores'))
//WebUI.delay(1)
////Eliminamos la linea
////Para efectos del test se elimina la cuenta anteriormente creada puesto que tiene errores
//_borrarLinea.call()
////Guardamos el plan de cuenta
//_guadarPlanExitoso.call()
//WebUI.delay(1)

//ID 4
println("<------ ID 4 ------>")
//Agregamos una nueva fila para crear una cuenta contable
_verificarCeldaAgregada.call()
WebUI.executeJavaScript('hot.setDataAtCell(1,1,"1111111")', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(1,2)', null)
WebUI.delay(1)
def String nombreCuenta = WebUI.executeJavaScript('return hot.getValue(1,2)', null)
println(nombreCuenta)
//Validamos que en realidad la celda del NOMBRE este vacia, en ese caso devuelve un null
assert nombreCuenta == null
WebUI.executeJavaScript('hot.setDataAtCell(1,3,"0")', null)
WebUI.delay(1)
//Guardamos la nueva cuenta SIN Moneda base
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonTerminar'))
WebUI.delay(1)
//PopUp aviso de errores
WebUI.verifyTextPresent('Se detectaron errores en la validación del plan de cuentas.', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonSIAvisoErrores'))
WebUI.delay(1)
//Eliminamos la linea
//Para efectos del test se elimina la cuenta anteriormente creada puesto que tiene errores
_borrarLinea.call()
//Guardamos el plan de cuenta
_guadarPlanExitoso.call()
WebUI.delay(1)

//ID 5
println("<------ ID 5 ------>")
//Buscamos la cuenta que se quiere eliminar
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonBuscar'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarCuenta'), '11111')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarPopUpBuscar'))
WebUI.delay(1)
WebUI.verifyTextPresent('11111', false)
WebUI.delay(1)
//Hacemos click para eliminar cuenta con asientos relacionados
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarBorrarCuenta'))
WebUI.delay(3)
WebUI.verifyTextPresent('La cuenta no se puede borrar porque se encuentra asociada al menos en un asiento.', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarVentanaAviso'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonBuscar'))
WebUI.delay(1)

//ID 7
println("<------ ID 7 ------>")
//Buscamos la cuenta que se quiere eliminar
WebUI.executeJavaScript('hot.selectCell(0,1)', null)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonBuscar'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/InputBuscarCuenta'), '111')
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarPopUpBuscar'))
WebUI.delay(1)
WebUI.verifyTextPresent('111', false)
WebUI.delay(1)
WebUI.verifyTextPresent('DISPONIBILIDADES', false)
WebUI.delay(1)
//Hacemos click para eliminar cuenta con cuentas por debajo
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonEliminarLinea'))
WebUI.delay(1)
WebUI.verifyTextPresent('La cuenta 111 que intenta eliminar tiene cuentas por debajo. Debe eliminar las cuentas que dependen de ella.', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarVentanaAviso'))
WebUI.delay(1)
//Guardamos el plan de cuenta
_guadarPlanExitoso.call()
WebUI.delay(1)


//ID 8
println("<------ ID 8 ------>")
//Agregamos una nueva fila para crear una cuenta contable
_verificarCeldaAgregada.call()
WebUI.executeJavaScript('hot.setDataAtCell(1,1,"9999888")', null)
WebUI.delay(1)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.TAB))
WebUI.delay(1)
WebUI.verifyTextPresent('El capítulo 9 no esta declarado en Propiedades.', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarVentanaAviso'))
WebUI.delay(1)
_borrarLinea.call()
//Guardamos el plan de cuenta
_guadarPlanExitoso.call()
WebUI.delay(1)

//ID 9
println("<------ ID 9 ------>")
//Agregamos una nueva fila para crear una cuenta contable
_verificarCeldaAgregada.call()
WebUI.executeJavaScript('hot.setDataAtCell(1,1,"11111")', null)
WebUI.delay(1)
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.TAB))
WebUI.delay(1)
WebUI.verifyTextPresent('El codigo contable 11111 ya existe en el plan de cuentas actual.', false)
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Plan de cuentas/BotonAceptarVentanaAviso'))
WebUI.delay(1)
_borrarLinea.call()
//Guardamos el plan de cuenta
_guadarPlanExitoso.call()
WebUI.delay(1)

//ID 10,11 y 12
println("<------ ID 10, 11 y 12 ------>")
//Agregamos una nueva fila para crear una cuenta contable
_verificarCeldaAgregada.call()
WebUI.executeJavaScript('hot.setDataAtCell(1,1,"11118")', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.setDataAtCell(1,2,"PRUEBA ID 10,11 y 12")', null)
WebUI.delay(1)
//En esta parte le escribimos un codigo de moneda que no existe en el maestro, y automaticamente se cambia a 0 cero
//Que es la moneda por defecto.
WebUI.executeJavaScript('hot.setDataAtCell(1,3,"9")', null)
WebUI.delay(1)
WebUI.executeJavaScript('hot.selectCell(1,3)', null)
WebUI.delay(1)
def String monedaBase = WebUI.executeJavaScript('return hot.getValue(1,3)', null)
println(monedaBase)
//Validamos que en realidad la celda del Moneda base tenga en valor por defecto que es 0
assert monedaBase == '0'
WebUI.delay(1)
/**
 * Esto se deja comentado hasta que se solucione el bug #212892, salta un popup de aviso que no tiene ninguna leyenda.
 */
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,4,"9")', null)
WebUI.delay(1)
//WebUI.executeJavaScript('hot.selectCell(1,4)', null)
//WebUI.delay(1)
def String operaEn = WebUI.executeJavaScript('return hot.getValue(1,4)', null)
println(operaEn)
//Validamos que en realidad la celda del Opera en este vacia, en ese caso devuelve un null
assert operaEn == ''
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
WebUI.executeJavaScript('hot.setDataAtCell(1,5,"9")', null)
WebUI.delay(1)
//WebUI.executeJavaScript('hot.selectCell(1,5)', null)
WebUI.delay(1)
def String monedaDC = WebUI.executeJavaScript('return hot.getValue(1,5)', null)
println(monedaDC)
//Validamos que en realidad la celda del Opera en este vacia, en ese caso devuelve un null
assert monedaDC == ''
WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
//Se borra la linea para efectos de la regresion
_borrarLinea.call()
//Guardamos el plan de cuenta
_guadarPlanExitoso.call()

WebUI.delay(1)
WebUI.executeJavaScript("alert('******** AQUI TERMINA EL TEST ********')", null)
WebUI.delay(3)
WebUI.closeBrowser()
