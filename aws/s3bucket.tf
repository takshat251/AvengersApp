# S3 Bucket
#
##########################################################################################
# Module maintainer:                               #
# Contact:                                              #
#                                                                                        #
# Description:                                       #
# README:   #
# ___________________                                                                    #
#                                                                                        #
#  Copyright                                    #
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

  source = "app/src/main/java/com/example/myavengersapp/AvengersActivity.kt"

  etag = filemd5("app/src/main/java/com/example/myavengersapp/AvengersActivity.kt")

}
