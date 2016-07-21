-- Private synonym
CREATE SYNONYM amr_user_syn_private FOR AMR_USER;
-- Public synonym
CREATE PUBLIC SYNONYM amr_user_syn_public FOR AMR_USER;

SELECT * FROM amr_user_syn_public;
SELECT * FROM amr_user_syn_private;

DROP PUBLIC SYNONYM amr_user_syn_public;
DROP SYNONYM amr_user_syn_private;
