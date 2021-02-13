package com.example.automessage

import android.content.Context
import android.util.Xml
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.File
import java.io.IOException
import java.io.StringWriter

class Preferences(val context: Context, val fileName: String) {
    private var enableService = false
    init {
        val preferenceFile = File(context.filesDir.toString() + "/" + fileName)
        if (preferenceFile.exists()) {
            readPreferences()
        }
    }

    private fun readPreferences()
    {
        try {
            val fileInputStream = context.openFileInput(fileName)
            val xmlPullParserFactory = XmlPullParserFactory.newInstance()
            val xmlPullParser = xmlPullParserFactory.newPullParser()
            xmlPullParser.setInput(fileInputStream, "UTF-8")
            var eventType = xmlPullParser.eventType
            var tag = ""
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    tag = xmlPullParser.name
                    if (tag == "EnableService") enableService = java.lang.Boolean.parseBoolean(xmlPullParser.nextText())
                }
                eventType = xmlPullParser.next()
            }
            fileInputStream.close()
        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun updatePreferences(enableService: String)
    {
        try {
            val xmlSerializer = Xml.newSerializer()
            val writer = StringWriter()
            xmlSerializer.setOutput(writer)
            xmlSerializer.startDocument("UTF-8", true)
            xmlSerializer.startTag("", "Preferences")
            xmlSerializer.startTag("", "EnableService")
            xmlSerializer.text(enableService)
            xmlSerializer.endTag("", "EnableService")
            xmlSerializer.endTag("", "Preferences")
            xmlSerializer.endDocument()
            val updatedXmlString = writer.toString()
            val fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
            fileOutputStream.write(updatedXmlString.toByteArray(), 0, updatedXmlString.length)
            fileOutputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getServiceEnableFlagValue(): Boolean
    {
        return enableService
    }
}