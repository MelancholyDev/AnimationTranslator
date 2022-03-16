from googletrans import Translator
import sys
sourceFile = sys.argv[1]
destanationFile = sys.argv[2]
sourceLanguage = sys.argv[3]
destanationLanguage = sys.argv[4]
f = open(sourceFile, 'r')
contents = f.read()
translator = Translator()
# translations1 = translator.translate(contents,src=sourceLanguage, dest='en')
# contents1 =translations1.text
translations = translator.translate(contents,src=sourceLanguage, dest=destanationLanguage)
yt_txt = open(destanationFile, 'w',encoding="utf-8")
yt_txt.write(translations.text)
yt_txt.close()
