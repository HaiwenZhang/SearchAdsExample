import os
import sys
import json
import mysql.connector


if __name__ == '__main__':

  input_file = sys.argv[1]

  cnx = mysql.connector.connect(
    user="root",
    password="123456789",
    host="127.0.0.1",
    database="AdServer"
  )

  cursor = cnx.cursor()

  add_ad = ("INSERT INTO ad "
    "(id, campaign_id, bid_price, price, brand, category, title, keywords, " 
    "description, detail_url, thumbnail) "
    "VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)")

  index = 0

  with open(input_file, "r") as lines:
    for line in lines:
      entry = json.loads(line.strip())
      ad_id = entry["adId"]
      campaign_id = entry["campaignId"]
      bid_price = entry["bidPrice"]
      price = entry["price"]
      brand = entry["brand"]
      category = entry["category"]
      title = entry["title"]
      keywords = entry["keyWords"]
      keywords = ",".join(keywords)
      description = entry["description"]
      detail_url = entry["detail_url"]
      thumbnail = entry["thumbnail"]
      data = (
        ad_id, campaign_id, bid_price, price, 
        brand, category, title, keywords, 
        description, detail_url, thumbnail)

      cursor.execute(add_ad, data)
      if index % 20 == 0:
        cnx.commit()
      index += 1

  cnx.commit()    
  cursor.close()
  cnx.close()