# S3 Bucket
#
##########################################################################################
# Module maintainer: CarBuff                                #
# Contact: carbuff@coxautoinc.com                                             #
#                                                                                        #
# Description: S3 Bucket Provider                                            #
# README: https://ghe.coxautoinc.com/master/README.md     #
# ___________________                                                                    #
#                                                                                        #
#  Copyright 2022 Cox Automotive Incorporated                                            #
#  All Rights Reserved.                                                                  #
#                                                                                        #
##########################################################################################

# Create a bucket
resource "aws_s3_bucket" "b1" {

  bucket = "s3-terraform-bucket-lab"

  acl    = "private"   # or can be "public-read"

  tags = {

    Name        = "My bucket"

    Environment = "Dev"

  }

}

# Upload an object
resource "aws_s3_bucket_object" "object" {

  bucket = aws_s3_bucket.b1.id

  key    = "profile"

  acl    = "private"  # or can be "public-read"

  source = "src/app.txt"

  etag = filemd5("src/app.txt")

}