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
 * Fecha creacion : 8-7-2022
 * QA : Santiago Marrugo
 */

//Escogemos la fecha inicial
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaInicial'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaInicial'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaInicial'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaInicial'), '01/03/2022')
WebUI.delay(1)
//Escogemos la fecha final
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaFinal'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaFinal'), Keys.chord(Keys.CONTROL,'a'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaFinal'), Keys.chord(Keys.BACK_SPACE))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/FechaFinal'), '31/03/2022')
WebUI.delay(1)
//Seleccionamos la cuenta de Perdidas y Ganancias
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/InputPerdidasYGanancias'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/InputPerdidasYGanancias'), '5601')
WebUI.delay(1)
//Seleccionamos la cuenta del Resultado del Ejercicio
WebUI.focus(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/InputResultadoEjercicio'))
WebUI.delay(1)
WebUI.setText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/InputResultadoEjercicio'), '3511')
WebUI.delay(1)
//Seleccionamos la moneda
WebUI.selectOptionByValue(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/DDMonedaDeCierre'), '1', false)
WebUI.delay(1)
//Se genera el Asiento
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/BotonAceptarPopupResultados'))
WebUI.delay(1)
def String resultadoEjercicio = WebUI.getText(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/MensajeResultadoEjercicioExitoso')) 
println(resultadoEjercicio)
assert resultadoEjercicio == 'Se generaron correctamente los asientos de Resultado del ejercicio.'
WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Empresas/Asientos automaticos/Resultados/BotonAceptarMensajeResultadoExitoso'))
WebUI.delay(2)
WebUI.verifyTextPresent('Inicio', false)






