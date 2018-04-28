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

  add_campaign = ("INSERT INTO campaign "
    "(id, budget)"
    "VALUES (%s, %s)")

  index = 0

  with open(input_file, "r") as lines:
    for line in lines:
      entry = json.loads(line.strip())
      campaign_id = entry["campaignId"]
      budget = entry["budget"]
      data = (campaign_id, budget)

      cursor.execute(add_campaign, data)
      if index % 20 == 0:
        cnx.commit()
      index += 1

  cnx.commit()    
  cursor.close()
  cnx.close()