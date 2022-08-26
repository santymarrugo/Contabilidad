package com.asientos.conty
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

/**
 * Fecha creacion : 13-04-2022
 * QA : Santiago Marrugo
 */

//El nombre del package es el nombre del modulo, en este caso es ASIENTOS
//Se crea la clase con el mismo nombre del Test
public class CrearAsiento {

	@Keyword
	def asiento_1() {
		//Ingresamos los datos del primer asiento
		WebUI.executeJavaScript('hot.setDataAtCell(0,5,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(0,6,"11111")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(0,9,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(0,10,"Entran PESOS dia 1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(0,11,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(0,12,"4300")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(0,13,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(0,14,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(0,18,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(0,19,"I")', null)

		//Creamos una nueva linea de asiento
		WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
		WebUI.delay(1)

		//Ingresamos los datos del segundo asiento
		WebUI.executeJavaScript('hot.setDataAtCell(1,5,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(1,7,"11112")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(1,9,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(1,10,"Salen DOLARES dia 1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(1,11,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(1,12,"100")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(1,13,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(1,14,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(1,18,"43")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(1,19,"I")', null)
	}
	@Keyword
	def asiento_2 () {
		//Creamos una nueva linea de asiento
		WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
		WebUI.delay(1)

		//Ingresamos los datos del tercer asiento
		WebUI.executeJavaScript('hot.setDataAtCell(2,5,"2")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(2,6,"11111")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(2,9,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(2,10,"Entran PESOS dia 2")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(2,11,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(2,12,"4300")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(2,13,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(2,14,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(2,18,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(2,19,"I")', null)

		//Creamos una nueva linea de asiento
		WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
		WebUI.delay(1)

		//Ingresamos los datos del cuarto asiento
		WebUI.executeJavaScript('hot.setDataAtCell(3,5,"2")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(3,7,"11112")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(3,9,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(3,10,"Salen DOLARES dia 2")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(3,11,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(3,12,"100")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(3,13,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(3,14,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(3,18,"43")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(3,19,"I")', null)
	}
	@Keyword
	def asiento_3 () {
		//Creamos una nueva linea de asiento
		WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
		WebUI.delay(1)

		//Ingresamos los datos del quinto asiento
		WebUI.executeJavaScript('hot.setDataAtCell(4,5,"3")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(4,6,"11111")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(4,9,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(4,10,"Entran PESOS dia 3")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(4,11,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(4,12,"4300")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(4,13,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(4,14,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(4,18,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(4,19,"I")', null)

		//Creamos una nueva linea de asiento
		WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
		WebUI.delay(1)

		//Ingresamos los datos del Sexto asiento
		WebUI.executeJavaScript('hot.setDataAtCell(5,5,"3")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(5,7,"11112")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(5,9,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(5,10,"Salen DOLARES dia 3")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(5,11,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(5,12,"100")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(5,13,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(5,14,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(5,18,"43")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(5,19,"I")', null)
	}
	@Keyword
	def asiento_4 () {
		//Creamos una nueva linea de asiento
		WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
		WebUI.delay(1)

		//Ingresamos los datos del septimo asiento
		WebUI.executeJavaScript('hot.setDataAtCell(6,5,"4")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(6,6,"11111")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(6,9,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(6,10,"Entran PESOS dia 4")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(6,11,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(6,12,"4300")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(6,13,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(6,14,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(6,18,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(6,19,"I")', null)

		//Creamos una nueva linea de asiento
		WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
		WebUI.delay(1)

		//Ingresamos los datos del octavo asiento
		WebUI.executeJavaScript('hot.setDataAtCell(7,5,"4")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(7,7,"11112")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(7,9,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(7,10,"Salen DOLARES dia 4")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(7,11,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(7,12,"100")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(7,13,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(7,14,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(7,18,"43")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(7,19,"I")', null)
	}
	@Keyword
	def asiento_5() {
		//Creamos una nueva linea de asiento
		WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
		WebUI.delay(1)

		//Ingresamos los datos del noveno asiento
		WebUI.executeJavaScript('hot.setDataAtCell(8,5,"5")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(8,6,"11111")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(8,9,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(8,10,"Entran PESOS dia 5")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(8,11,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(8,12,"4300")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(8,13,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(8,14,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(8,18,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(8,19,"I")', null)

		//Creamos una nueva linea de asiento
		WebUI.click(findTestObject('Object Repository/_Conty/Menu Principal/Carpetas/Asientos/BotonNuevaLinea'))
		WebUI.delay(1)

		//Ingresamos los datos del decimo asiento
		WebUI.executeJavaScript('hot.setDataAtCell(9,5,"5")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(9,7,"11112")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(9,9,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(9,10,"Salen DOLARES dia 5")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(9,11,"1")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(9,12,"100")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(9,13,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(9,14,"0")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(9,18,"43")', null)
		WebUI.sendKeys(findTestObject(null), Keys.chord(Keys.ARROW_RIGHT))
		WebUI.executeJavaScript('hot.setDataAtCell(9,19,"I")', null)

		//verificamos que se hayan creado los 10 asiento y lo verificamos seleccionando la celda (9,5)
		WebUI.executeJavaScript('hot.selectCell(9,5)', null)
		def String celdaFinal = WebUI.executeJavaScript('return hot.getSelected()', null)
		println(celdaFinal)
		assert celdaFinal == '[[9, 5, 9, 5]]'
	}
}