package Views;

   class CampoVazio extends Exception
{
      // Parameterless Constructor
      public CampoVazio() {}

      // Constructor that accepts a message
      public CampoVazio(String message)
      {
         super(message);
      }
 }
